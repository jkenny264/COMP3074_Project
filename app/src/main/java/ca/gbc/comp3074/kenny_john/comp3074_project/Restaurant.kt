package ca.gbc.comp3074.kenny_john.comp3074_project

import android.content.Context

data class Restaurant(
    val id: String,
    // id is string here temporarily for testing purposes.
    // Will be changed to Int when DB is implemented.
    val name: String,
//    val Address: String,
//    val Phone: String,
//    val Description: String,
//    val tags: Array<String>
    val rating: String,
)




fun loadRestaurants(context: Context): List<Restaurant> {
    val ids = context.resources.getStringArray(R.array.restaurant_ids)
    val names = context.resources.getStringArray(R.array.restaurant_names)
    val ratings = context.resources.getStringArray(R.array.ratings)

    return ids.zip(names).zip(ratings) {
            (id, name), rating -> Restaurant(id, name, rating)
    }
}

fun loadRestaurantById(context: Context, id: Int): Restaurant? {
    val restaurants = loadRestaurants(context);
    val restaurant: Restaurant? = restaurants.find { it.id == id.toString()}
    return restaurant;
}