package com.geolocationapplication.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Coarse_Geolocations")
data class CoarseGeolocationEntity(
    @PrimaryKey
    @ColumnInfo("coarse_geolocation_entity_id") val coarseGeolocationEntityId : Long?,
    @ColumnInfo("continent") val continent : String?,
    @ColumnInfo("continent_code") val continentCode : String?,
    @ColumnInfo("region") val region : String?,
    @ColumnInfo("region_name") val regionName : String?,
    @ColumnInfo("city") val city : String?,
    @ColumnInfo("district") val district : String?,
    @ColumnInfo("zip_code") val zipCode : String?
)
