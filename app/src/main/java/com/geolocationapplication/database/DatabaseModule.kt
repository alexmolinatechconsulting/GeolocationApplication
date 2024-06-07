package com.geolocationapplication.database

import org.koin.dsl.module
import androidx.room.Room
import org.koin.android.ext.koin.androidContext

val DatabaseModule = module {

    single{
        Room.databaseBuilder(
            androidContext(),
            GeolocationDatabase::class.java,
            "geolocation-database"
        )
        .fallbackToDestructiveMigration()
        .build()
    }
}