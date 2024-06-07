import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.geolocationapplication.database.entity.GeolocationNameDetailsEntity
import com.geolocationapplication.database.entity.GeolocationNameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GeolocationNameDAO {

    @Query("SELECT EXISTS(" +
            "SELECT * FROM Geolocation_Names WHERE " +
            "name = :geolocationNameEntity.name AND " +
            "name_details_id = :geolocationNameEntity.nameDetailsId" +
            ")"
    )
    suspend fun existsWithoutPrimaryKey(geolocationNameEntity: GeolocationNameEntity) : Boolean


    @Query("SELECT * FROM Geolocation_Names WHERE name = :name")
    suspend fun getGeolocationNameEntityByName(name : String?) : List<GeolocationNameEntity>
    // name might have different details

    @Insert
    suspend fun createGeolocationName(entity : GeolocationNameEntity)

    // TODO : this should be ensured unique and sinlge
    @Query(
        "SELECT * FROM Geolocation_Names WHERE " +
        "name = :geolocationNameEntity.name AND " +
        "name_details_id = :geolocationNameEntity.nameDetailsId"
    )
    suspend fun getGeolocationNameEntityId(geolocationNameEntity: GeolocationNameEntity) : GeolocationNameEntity
}