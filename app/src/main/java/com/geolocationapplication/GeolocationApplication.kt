package com.geolocationapplication

import android.app.Application
import com.geolocationapplication.repository.RepositoryModule
import com.geolocationapplication.service.ServiceModule
import com.geolocationapplication.service.network.NetworkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GeolocationApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@GeolocationApplication)
            modules(listOf(NetworkModule, RepositoryModule, ServiceModule))
        }
    }
}