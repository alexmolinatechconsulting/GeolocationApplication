package com.geolocationapplication.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Geolocation_Name_Details")
data class GeolocationNameDetailsEntity(
    @PrimaryKey
    @ColumnInfo("geolocation_name_details_entity_id") val geolocationNameDetailsEntityId : Long?,
    @ColumnInfo("isp") val isp : String?,
    @ColumnInfo("organization") val organization : String?,
    @ColumnInfo("autonomous_system") val autonomousSystem : String?,
    @ColumnInfo("autonomous_system_name") val autonomousSystemName : String?,
    @ColumnInfo("reverse_dns") val reverseDNS : String?,
    @ColumnInfo("mobile") val mobile : Boolean?,
    @ColumnInfo("proxy") val proxy : Boolean?,
    @ColumnInfo("hosting") val hosting : Boolean?
)