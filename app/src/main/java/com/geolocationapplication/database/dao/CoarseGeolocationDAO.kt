package com.geolocationapplication.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.geolocationapplication.database.entity.CoarseGeolocationEntity

@Dao
interface CoarseGeolocationDAO {

    @Query("SELECT EXISTS(" +
            "SELECT * FROM Coarse_Geolocations WHERE " +
            "continent = :coarseGeolocationEntity.continent AND " +
            "continentCode = :coarseGeolocationEntity.continentCode AND " +
            "region = :coarseGeolocationEntity.region AND " +
            "regionName = :coarseGeolocationEntity.regionName AND " +
            "city = :coarseGeolocationEntity.city AND " +
            "district = :coarseGeolocationEntity.district AND " +
            "zip_code = :coarseGeolocationEntity.zipCode" +
           ")"
    )
    suspend fun existsWithoutPrimaryKey(coarseGeolocationEntity: CoarseGeolocationEntity) : Boolean

    @Insert
    suspend fun createCoarseGeolocation(coarseGeolocationEntity: CoarseGeolocationEntity)

    // TODO : this should be ensured unique and sinlge
    @Query("SELECT * FROM Coarse_Geolocations WHERE " +
            "continent = :coarseGeolocationEntity.continent AND " +
            "continentCode = :coarseGeolocationEntity.continentCode AND " +
            "region = :coarseGeolocationEntity.region AND " +
            "regionName = :coarseGeolocationEntity.regionName AND " +
            "city = :coarseGeolocationEntity.city AND " +
            "district = :coarseGeolocationEntity.district AND " +
            "zip_code = :coarseGeolocationEntity.zipCode"
    )
    suspend fun getCoarseGeolocationEntityId(coarseGeolocationEntity: CoarseGeolocationEntity) : CoarseGeolocationEntity
}