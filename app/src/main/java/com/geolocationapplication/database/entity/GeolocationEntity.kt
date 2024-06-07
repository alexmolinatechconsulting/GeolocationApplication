package com.geolocationapplication.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Geolocations")
data class GeolocationEntity(
    @PrimaryKey
    @ColumnInfo("geolocation_entity_id") val geolocationEntityId : Long?,
    @ColumnInfo("geolocation_name_entity_id") val geolocationNameEntityId : Long?,
    @ColumnInfo("coarse_geolocation_entity_id")val coarseGeolocationEntityId : Long?, // maybe this is a problem and only have precision
    @ColumnInfo("precision_geolocation_entity_id") val precisionGeolocationEntityId : Long?
)