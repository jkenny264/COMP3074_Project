package ca.gbc.comp3074.kenny_john.comp3074_project

import android.content.Context

data class Rating(
    val id: String,
    // id is string here temporarily for testing purposes.
    // Will be changed to Int when DB is implemented.
    val title: String
//    val content: String

)




fun loadRatings(context: Context): List<Rating> {
    val ids = context.resources.getStringArray(R.array.rating_ids)
    val title = context.resources.getStringArray(R.array.rating_titles)

    return ids.zip(title){
            id, title -> Rating(id, title)
    }
}
