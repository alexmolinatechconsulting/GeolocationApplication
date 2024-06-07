package com.geolocationapplication.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("Geolocation_Names")
data class GeolocationNameEntity(
    @PrimaryKey
    @ColumnInfo("geolocation_name_entity_id") val geolocationNameEntityId : Long?,
    @ColumnInfo("name") val name : String?,
    @ColumnInfo("name_details_entity_id") val geolocationNameDetailsEntityId : Long?
)