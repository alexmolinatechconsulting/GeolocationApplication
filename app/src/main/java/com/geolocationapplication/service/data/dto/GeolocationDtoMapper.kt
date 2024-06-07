package com.geolocationapplication.service.data.dto

import com.geolocationapplication.database.entity.CoarseGeolocationEntity
import com.geolocationapplication.database.entity.GeolocationEntity
import com.geolocationapplication.database.entity.GeolocationInsertionTimestampEntity
import com.geolocationapplication.database.entity.GeolocationNameDetailsEntity
import com.geolocationapplication.database.entity.GeolocationNameEntity
import com.geolocationapplication.database.entity.PrecisionGeolocationEntity

class GeolocationDtoMapper {

    fun createCoarseGeolocationEntity(coarseGeolocationEntityId : Long?, geolocationDto: GeolocationDto) : CoarseGeolocationEntity {

        val continent = geolocationDto.continent
        val continentCode = geolocationDto.continentCode
        val region = geolocationDto.region
        val regionName = geolocationDto.regionName
        val city = geolocationDto.city
        val district = geolocationDto.district
        val zipCode = geolocationDto.zipCode

        val coarseGeolocationEntity = CoarseGeolocationEntity(
            coarseGeolocationEntityId = coarseGeolocationEntityId,
            continent = continent,
            continentCode = continentCode,
            region = region,
            regionName = regionName,
            city = city,
            district = district,
            zipCode = zipCode
        )

        return coarseGeolocationEntity
    }

    fun createPrecisionGeolocationEntity(precisionGeolocationEntityId : Long?, coarseGeolocationEntityId: Long?, geolocationDto: GeolocationDto) : PrecisionGeolocationEntity {

        val latitude = geolocationDto.latitude
        val longitude = geolocationDto.longitude
        val timezone = geolocationDto.timezone
        val offset = geolocationDto.offset

        val precisionGeolocationEntity = PrecisionGeolocationEntity(
            precisionGeolocationEntityId = precisionGeolocationEntityId,
            coarseGeolocationEntityId = coarseGeolocationEntityId,
            latitude = latitude,
            longitude = longitude,
            timezone = timezone,
            offset = offset
        )

        return precisionGeolocationEntity
    }

    fun createGeolocationNameEntity(geolocationNameEntityId : Long?, geolocationNameDetailsEntityId : Long?, geolocationDto: GeolocationDto) : GeolocationNameEntity {

        val name = geolocationDto.name

        val geolocationNameEntity = GeolocationNameEntity(
            geolocationNameEntityId = geolocationNameEntityId,
            name = name,
            geolocationNameDetailsEntityId = geolocationNameDetailsEntityId
        )

        return geolocationNameEntity
    }

    fun createGeolocationNameDetailsEntity(geolocationNameDetailsEntityId : Long?, geolocationDto: GeolocationDto) : GeolocationNameDetailsEntity {

        val isp = geolocationDto.isp
        val organization = geolocationDto.organization
        val autonomousSystem = geolocationDto.autonomousSystem
        val autonomousSystemName = geolocationDto.autonomousSystemName
        val reverseDNS = geolocationDto.reverseDNS
        val mobile = geolocationDto.mobile
        val proxy = geolocationDto.proxy
        val hosting = geolocationDto.hosting

        val geolocationNameDetailsEntity = GeolocationNameDetailsEntity(
            geolocationNameDetailsEntityId = geolocationNameDetailsEntityId,
            isp = isp,
            organization = organization,
            autonomousSystem = autonomousSystem,
            autonomousSystemName = autonomousSystemName,
            reverseDNS = reverseDNS,
            mobile = mobile,
            proxy = proxy,
            hosting = hosting
        )

        return geolocationNameDetailsEntity
    }

    fun createGeolocationEntity(geolocationEntityId : Long?, geolocationNameEntityId: Long?, coarseGeolocationEntityId: Long?, precisionGeolocationEntityId: Long?) : GeolocationEntity {

        val geolocationEntity = GeolocationEntity(
            geolocationEntityId = geolocationEntityId,
            geolocationNameEntityId = geolocationNameEntityId,
            coarseGeolocationEntityId = coarseGeolocationEntityId,
            precisionGeolocationEntityId = precisionGeolocationEntityId
        )

        return geolocationEntity
    }

    fun createGeolocationInsertionTimestampEntity(geolocationInsertionTimestampEntityId: Long?, geolocationEntityId : Long?, utcTimestamp: String?) : GeolocationInsertionTimestampEntity {

        val geolocationInsertionTimestampEntity = GeolocationInsertionTimestampEntity(
            geolocationInsertionTimestampEntityId = geolocationInsertionTimestampEntityId,
            geolocationEntityId = geolocationEntityId,
            utcTimestamp = utcTimestamp
        )

        return geolocationInsertionTimestampEntity
    }
}