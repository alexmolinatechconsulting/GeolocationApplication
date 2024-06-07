package com.geolocationapplication.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.geolocationapplication.database.GeolocationDatabase
import com.geolocationapplication.database.entity.GeolocationEntity
import com.geolocationapplication.service.GeolocationService
import com.geolocationapplication.service.data.dto.GeolocationDtoMapper
import kotlinx.coroutines.flow.*
import java.time.Instant
import java.time.ZoneId
import java.util.UUID

class GeolocationRepository(
    private val geolocationService: GeolocationService,
    private val geolocationDatabase: GeolocationDatabase
) {

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun getMostRecentGeolocationByName(name: String?): Flow<GeolocationEntity> = flow {
        // Retrieve the name entity based on the provided name
        val nameEntity =
            geolocationDatabase.getGeolocationNameDAO().getGeolocationNameEntityByName(name).firstOrNull()

        // If no name entity is found, return empty flow
        if (nameEntity == null) {
            return@flow
        }

        // Get local geolocation entities based on the name ID
        val localGeolocationEntitiesFlow = geolocationDatabase.getGeolocationDAO()
            .getGeolocationsByNameId(nameEntity.geolocationNameEntityId)

        // Get the latest local geolocation entity based on the insertion timestamp
        val latestLocalGeolocationEntity = localGeolocationEntitiesFlow
            .map { entities ->
                val ids = entities.mapNotNull { it.geolocationEntityId }
                val timestamps = geolocationDatabase.getGeolocationInsertionTimestampDAO()
                    .getGeolocationInsertionTimestampByGeolocationIds(ids)
                    .firstOrNull() ?: emptyList()

                val latestTimestampEntity = timestamps.maxByOrNull { Instant.parse(it.utcTimestamp) }
                entities.find { it.geolocationEntityId == latestTimestampEntity?.geolocationEntityId }
            }
            .firstOrNull()

        // Emit the latest local geolocation entity if it exists
        if (latestLocalGeolocationEntity != null) {
            emit(latestLocalGeolocationEntity)
        }

        // Fetch the remote geolocation data
        val remoteGeolocationDto = geolocationService.getGeolocationByName(name)
        val mapper = GeolocationDtoMapper()

        // Map and save remote geolocation data into local database
        val coarseGeolocationEntity = mapper.createCoarseGeolocationEntity(null, remoteGeolocationDto).let {
            if (geolocationDatabase.getCoarseGeolocationDAO().existsWithoutPrimaryKey(it)) {
                geolocationDatabase.getCoarseGeolocationDAO().getCoarseGeolocationEntityId(it)
            } else {
                geolocationDatabase.getCoarseGeolocationDAO().createCoarseGeolocation(it.apply {  UUID.randomUUID().mostSignificantBits })
                it
            }
        }

        val precisionGeolocationEntity = mapper.createPrecisionGeolocationEntity(
            null,
            coarseGeolocationEntity.coarseGeolocationEntityId,
            remoteGeolocationDto
        ).let {
            if (geolocationDatabase.getPrecisionGeolocationDAO().existsWithoutPrimaryKey(it)) {
                geolocationDatabase.getPrecisionGeolocationDAO().getPrecisionGeolocationEntityId(it)
            } else {
                geolocationDatabase.getPrecisionGeolocationDAO().createPrecisionGeolocation(it.apply {  UUID.randomUUID().mostSignificantBits })
                it
            }
        }

        val geolocationNameDetailsEntity = mapper.createGeolocationNameDetailsEntity(null, remoteGeolocationDto).let {
            if (geolocationDatabase.getGeolocationNameDetailsDAO().existsWithoutPrimaryKey(it)) {
                geolocationDatabase.getGeolocationNameDetailsDAO().getGeolocationNameDetailsEntityId(it)
            } else {
                geolocationDatabase.getGeolocationNameDetailsDAO().createGeolocationNameDetails(it.apply {  UUID.randomUUID().mostSignificantBits })
                it
            }
        }

        val geolocationNameEntity = mapper.createGeolocationNameEntity(
            null,
            geolocationNameDetailsEntity.geolocationNameDetailsEntityId,
            remoteGeolocationDto
        ).let {
            if (geolocationDatabase.getGeolocationNameDAO().existsWithoutPrimaryKey(it)) {
                geolocationDatabase.getGeolocationNameDAO().getGeolocationNameEntityId(it)
            } else {
                geolocationDatabase.getGeolocationNameDAO().createGeolocationName(it.apply { UUID.randomUUID().mostSignificantBits })
                it
            }
        }

        val geolocationEntity = mapper.createGeolocationEntity(
            null,
            geolocationNameEntityId = geolocationNameEntity.geolocationNameEntityId,
            coarseGeolocationEntity.coarseGeolocationEntityId,
            precisionGeolocationEntity.precisionGeolocationEntityId
        ).let {
            if (geolocationDatabase.getGeolocationDAO().existsWithoutPrimaryKey(it)) {
                geolocationDatabase.getGeolocationDAO().getGeolocationEntityId(it)
            } else {
                geolocationDatabase.getGeolocationDAO().createGeolocation(it.apply {  UUID.randomUUID().mostSignificantBits })
                it
            }
        }

        val geolocationInsertionTimestampEntity = mapper.createGeolocationInsertionTimestampEntity(
            UUID.randomUUID().mostSignificantBits,
            geolocationEntity.geolocationEntityId,
            Instant.now().atZone(ZoneId.systemDefault()).toString()
        )
        geolocationDatabase.getGeolocationInsertionTimestampDAO()
            .createGeolocationInsertionTimestamps(geolocationInsertionTimestampEntity)

        // Emit the latest remote geolocation entity
        emit(geolocationEntity)
    }
}