package com.geolocationapplication.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Geolocation_Insertion_Timestamps")
data class GeolocationInsertionTimestampEntity(
    @PrimaryKey
    @ColumnInfo("geolocation_insertion_timestamp_entity_id") val geolocationInsertionTimestampEntityId : Long?,
    @ColumnInfo("geolocation_entity_id") val geolocationEntityId: Long?,
    @ColumnInfo("utc_timestamp") val utcTimestamp : String?
)