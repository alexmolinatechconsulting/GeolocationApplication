package com.geolocationapplication.service.data.dto

import com.google.gson.annotations.SerializedName

data class GeolocationDto(
    @SerializedName("status") val status : String?,
    @SerializedName("message") val message : String?,
    @SerializedName("continent") val continent : String?,
    @SerializedName("continentCode") val continentCode : String?,
    @SerializedName("country") val country : String?,
    @SerializedName("countryCode") val countryCode : String?,
    @SerializedName("region") val region : String?,
    @SerializedName("regionName") val regionName : String?,
    @SerializedName("city") val city : String?,
    @SerializedName("district") val district : String?,
    @SerializedName("zip") val zipCode : String?,
    @SerializedName("lat") val latitude : Float?,
    @SerializedName("lon") val longitude : Float?,
    @SerializedName("timezone") val timezone : String?,
    @SerializedName("offset") val offset : Int?,
    @SerializedName("currency") val currency : String?,
    @SerializedName("isp") val isp : String?,
    @SerializedName("arg") val organization : String?,
    @SerializedName("as") val autonomousSystem : String?,
    @SerializedName("asname") val autonomousSystemName : String?,
    @SerializedName("reverse") val reverseDNS : String?,
    @SerializedName("mobile") val mobile : Boolean?,
    @SerializedName("proxy") val proxy : Boolean?,
    @SerializedName("hosting") val hosting : Boolean?,
    @SerializedName("query") val name : String?,
)
