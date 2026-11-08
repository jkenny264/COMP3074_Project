package ca.gbc.comp3074.kenny_john.comp3074_project

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow



@Dao
interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(restaurant: Restaurant)

    @Delete
    suspend fun delete(restaurant: Restaurant)

    @Query("SELECT * FROM restaurants ORDER BY id")
    fun getAllRestaurants(): Flow<List<Restaurant>>

    @Query(
        "SELECT * FROM restaurants " +
                "WHERE name LIKE '%' || :searchText || '%' " +
                "ORDER BY name"
    )
    fun searchRestaurants(searchText: String): Flow<List<Restaurant>>

    @Query("SELECT * FROM restaurants WHERE id = :id")
    fun getRestaurantById(id: Int): Flow<Restaurant?>

    @Update
    suspend fun update(restaurant: Restaurant)
}