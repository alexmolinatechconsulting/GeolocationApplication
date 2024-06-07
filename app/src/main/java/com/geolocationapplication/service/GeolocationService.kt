package com.geolocationapplication.service

import com.geolocationapplication.service.api.GeolocationApi
import com.geolocationapplication.service.data.dto.GeolocationDto

class GeolocationService(private val geolocationApi: GeolocationApi) {

    // no real use case as such just mimics the backing api
    suspend fun getGeolocationByName(name : String?) : GeolocationDto {
        return geolocationApi.getGeolocationByName(name)
    }
}