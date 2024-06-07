package com.geolocationapplication.service

import com.geolocationapplication.service.api.GeolocationApi
import com.geolocationapplication.service.api.implementation.DefaultGeolocationApiImpl
import org.koin.dsl.module

val ServiceModule = module{
    single<GeolocationApi>{DefaultGeolocationApiImpl(get())}
    single<GeolocationService>{GeolocationService(get())}
}