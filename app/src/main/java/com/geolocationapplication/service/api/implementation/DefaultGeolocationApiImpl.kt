package com.geolocationapplication.service.api.implementation

import com.geolocationapplication.service.api.GeolocationApi
import com.geolocationapplication.service.data.dto.GeolocationDto
import retrofit2.Retrofit

class DefaultGeolocationApiImpl(private var retrofit : Retrofit) : GeolocationApi {

    override suspend fun getGeolocationByName(name: String?): GeolocationDto {
        val service = retrofit.create(GeolocationApi::class.java)
        return service.getGeolocationByName(name)
    }
}