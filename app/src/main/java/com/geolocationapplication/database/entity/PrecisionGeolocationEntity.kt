package com.geolocationapplication.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Precision_Geolocations")
data class PrecisionGeolocationEntity(
    @PrimaryKey
    @ColumnInfo("precision_geolocation_entity_id") val precisionGeolocationEntityId : Long?,
    @ColumnInfo("coarse_geolocation_entity_id") val coarseGeolocationEntityId : Long?,
    @ColumnInfo("latitude") val latitude : Float?,
    @ColumnInfo("longitude") val longitude : Float?,
    @ColumnInfo("timezone") val timezone : String?,
    @ColumnInfo("offset") val offset : Int?
)