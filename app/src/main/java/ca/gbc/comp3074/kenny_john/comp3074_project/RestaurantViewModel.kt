package ca.gbc.comp3074.kenny_john.comp3074_project

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.text.insert

class RestaurantViewModel(
    private val restaurantDao: RestaurantDao
) : ViewModel() {

    val restaurants: Flow<List<Restaurant>> =
        restaurantDao.getAllRestaurants()

    fun addRestaurant(
        name: String,
        address: String,
        rating: String
    ) {
        viewModelScope.launch {
            restaurantDao.insert(
                Restaurant(
                    name = name,
                    address = address,
                    rating = rating
                )
            )
        }
    }

    fun deleteRestaurant(restaurant: Restaurant) {
        viewModelScope.launch {
            restaurantDao.delete(restaurant)
        }
    }

    fun getRestaurantById(id: Int): Flow<Restaurant?> {
        return restaurantDao.getRestaurantById(id)
    }

    fun updateRestaurant(restaurant: Restaurant) {
        viewModelScope.launch {
            restaurantDao.update(restaurant)
        }
    }

}