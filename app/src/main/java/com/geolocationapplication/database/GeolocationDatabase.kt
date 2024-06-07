package com.geolocationapplication.database

import GeolocationDAO
import GeolocationInsertionTimestampDAO
import GeolocationNameDAO
import GeolocationNameDetailsDAO
import PrecisionGeolocationDAO
import androidx.room.Database
import androidx.room.RoomDatabase
import com.geolocationapplication.database.dao.CoarseGeolocationDAO
import com.geolocationapplication.database.entity.CoarseGeolocationEntity
import com.geolocationapplication.database.entity.GeolocationEntity
import com.geolocationapplication.database.entity.GeolocationInsertionTimestampEntity
import com.geolocationapplication.database.entity.GeolocationNameDetailsEntity
import com.geolocationapplication.database.entity.GeolocationNameEntity
import com.geolocationapplication.database.entity.PrecisionGeolocationEntity

@Database(
    entities = [
        CoarseGeolocationEntity::class,
        PrecisionGeolocationEntity::class,
        GeolocationNameEntity::class,
        GeolocationNameDetailsEntity::class,
        GeolocationEntity::class,
        GeolocationInsertionTimestampEntity::class
    ],
    version = 2,
    exportSchema = false
)

// TODO : fix dependency
abstract class GeolocationDatabase : RoomDatabase() {

    abstract fun getCoarseGeolocationDAO() : CoarseGeolocationDAO
    abstract fun getPrecisionGeolocationDAO() : PrecisionGeolocationDAO
    abstract fun getGeolocationNameDAO() : GeolocationNameDAO
    abstract fun getGeolocationNameDetailsDAO() : GeolocationNameDetailsDAO
    abstract fun getGeolocationDAO() : GeolocationDAO
    abstract fun getGeolocationInsertionTimestampDAO() : GeolocationInsertionTimestampDAO
}