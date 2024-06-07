import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.geolocationapplication.database.entity.CoarseGeolocationEntity
import com.geolocationapplication.database.entity.PrecisionGeolocationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PrecisionGeolocationDAO {

    @Query("SELECT EXISTS(" +
            "SELECT * FROM Precision_Geolocations WHERE " +
            "coarse_geolocation_entity_id = :precisionGeolocationEntity.coarseGeolocationEntityId AND " +
            "latitude = :precisionGeolocationEntity.latitude AND " +
            "longitude = :precisionGeolocationEntity.longitude AND " +
            "timezone = :precisionGeolocationEntity.timezone AND " +
            "offset = :precisionGeolocationEntity.offset" +
            ")"
    )
    suspend fun existsWithoutPrimaryKey(precisionGeolocationEntity: PrecisionGeolocationEntity) : Boolean

    @Query("SELECT * FROM Precision_Geolocations") //
    suspend fun getAllPrecisionGeolocations() : Flow<List<PrecisionGeolocationEntity>>
    // its a flow because insertions might be happening

    @Insert
    suspend fun createPrecisionGeolocation(entity : PrecisionGeolocationEntity)

    // TODO : this should be ensured unique and sinlge
    @Query("SELECT * FROM Precision_Geolocations WHERE " +
            "coarse_geolocation_entity_id = :precisionGeolocationEntity.coarseGeolocationEntityId AND " +
            "latitude = :precisionGeolocationEntity.latitude AND " +
            "longitude = :precisionGeolocationEntity.longitude AND " +
            "timezone = :precisionGeolocationEntity.timezone AND " +
            "offset = :precisionGeolocationEntity.offset"
    )
    suspend fun getPrecisionGeolocationEntityId(precisionGeolocationEntity: PrecisionGeolocationEntity) : PrecisionGeolocationEntity
}