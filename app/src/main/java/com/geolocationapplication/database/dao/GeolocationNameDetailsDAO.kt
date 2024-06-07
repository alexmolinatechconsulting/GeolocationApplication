import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.geolocationapplication.database.entity.GeolocationNameDetailsEntity
import com.geolocationapplication.database.entity.PrecisionGeolocationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GeolocationNameDetailsDAO {

    @Query("SELECT EXISTS(" +
            "SELECT * FROM Geolocation_Name_Details WHERE " +
            "isp = :geolocationNameDetailsEntity.isp AND " +
            "organization = :geolocationNameDetailsEntity.organization AND " +
            "autonomous_system = :geolocationNameDetailsEntity.autonomousSystem AND " +
            "autonomous_system_name= :geolocationNameDetailsEntity.autonomousSystemName AND " +
            "reverse_dns = :geolocationNameDetailsEntity.reverseDNS AND " +
            "mobile = :geolocatioNameDetailsnEntity.mobile AND " +
            "proxy = :geolocatioNameDetailsnEntity.proxy AND " +
            "hosting = :geolocationNameDetailsEntity.hosting" +
            ")"
    )
    suspend fun existsWithoutPrimaryKey(geolocationNameDetailsEntity: GeolocationNameDetailsEntity) : Boolean

    @Insert
    suspend fun createGeolocationNameDetails(entity : GeolocationNameDetailsEntity)

    // TODO : this should be ensured unique and sinlge
    @Query(
        "SELECT * FROM Geolocation_Name_Details WHERE " +
                "isp = :geolocationNameDetailsEntity.isp AND " +
                "organization = :geolocationNameDetailsEntity.organization AND " +
                "autonomous_system = :geolocationNameDetailsEntity.autonomousSystem AND " +
                "autonomous_system_name= :geolocationNameDetailsEntity.autonomousSystemName AND " +
                "reverse_dns = :geolocationNameDetailsEntity.reverseDNS AND " +
                "mobile = :geolocatioNameDetailsnEntity.mobile AND " +
                "proxy = :geolocatioNameDetailsnEntity.proxy AND " +
                "hosting = :geolocationNameDetailsEntity.hosting"
    )
    suspend fun getGeolocationNameDetailsEntityId(geolocationNameDetailsEntity: GeolocationNameDetailsEntity) : GeolocationNameDetailsEntity
}