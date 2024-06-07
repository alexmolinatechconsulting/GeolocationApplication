package com.geolocationapplication.service.api

import com.geolocationapplication.BuildConfig
import com.geolocationapplication.service.data.dto.GeolocationDto
import retrofit2.http.GET
import retrofit2.http.Path

interface GeolocationApi {

    @GET(BuildConfig.BASE_URL + "/{name}")
    suspend fun getGeolocationByName(@Path("name") name : String?) : GeolocationDto
}