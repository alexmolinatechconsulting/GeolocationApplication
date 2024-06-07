import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.geolocationapplication.database.entity.GeolocationInsertionTimestampEntity
import com.geolocationapplication.database.entity.GeolocationNameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GeolocationInsertionTimestampDAO {

    @Query("SELECT EXISTS(" +
            "SELECT * FROM Geolocation_Insertion_Timestamps WHERE " +
            "geolocation_entity_id = :geolocationInsertionTimestampEntity.geolocationEntityId AND " +
            "utc_timestamp = :geolocationInsertionTimestampEntity.utcTimestamp" +
            ")"
    )
    suspend fun existsWithoutPrimaryKey(geolocationInsertionTimestampEntity: GeolocationInsertionTimestampEntity) : Boolean


    @Query("SELECT * FROM Geolocation_Insertion_Timestamps WHERE geolocation_entity_id IN (:geolocationIds)")
    suspend fun getGeolocationInsertionTimestampByGeolocationIds(geolocationIds : List<Long>?) : Flow<List<GeolocationInsertionTimestampEntity>>

    @Insert
    suspend fun createGeolocationInsertionTimestamps(entity : GeolocationInsertionTimestampEntity)
}