import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.geolocationapplication.database.entity.GeolocationEntity
import com.geolocationapplication.database.entity.GeolocationNameDetailsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GeolocationDAO {

    // TODO : Add queries according to needs
    @Query("SELECT EXISTS(" +
            "SELECT * FROM Geolocations WHERE " +
            "geolocation_entity_id = :geolocationEntity.geolocationEntityId AND " +
            "geolocation_name_entity_id = :geolocationEntity.geolocationNameEntityId AND " +
            "coarse_geolocation_entity_id = :geolocationEntity.coarseGeolocationEntityId AND " +
            "precision_geolocation_entity_id = :geolocationEntity.precisionGeolocationEntityId AND " +
            ")"
    )
    suspend fun existsWithoutPrimaryKey(geolocationEntity: GeolocationEntity) : Boolean


    @Query("SELECT * FROM Geolocations WHERE geolocation_name_entity_id = :nameId")
    suspend fun getGeolocationsByNameId(nameId : Long?) : Flow<List<GeolocationEntity>>
    // if more geolocations are inserted, would want them emitted

    @Insert
    suspend fun createGeolocation(entity : GeolocationEntity)

    // TODO : this should be ensured unique and sinlge
    @Query(
        "SELECT * FROM Geolocations WHERE " +
        "geolocation_entity_id = :geolocationEntity.geolocationEntityId AND " +
        "geolocation_name_entity_id = :geolocationEntity.geolocationNameEntityId AND " +
        "coarse_geolocation_entity_id = :geolocationEntity.coarseGeolocationEntityId AND " +
        "precision_geolocation_entity_id = :geolocationEntity.precisionGeolocationEntityId"
    )
    suspend fun getGeolocationEntityId(geolocationEntity: GeolocationEntity) : GeolocationEntity
}