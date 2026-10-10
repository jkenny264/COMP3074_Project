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
)




fun loadRestaurants(context: Context): List<Restaurant> {
    val ids = context.resources.getStringArray(R.array.restaurant_ids)
    val names = context.resources.getStringArray(R.array.restaurant_names)

    return ids.zip(names){
        id, name -> Restaurant(id, name)
    }
}
