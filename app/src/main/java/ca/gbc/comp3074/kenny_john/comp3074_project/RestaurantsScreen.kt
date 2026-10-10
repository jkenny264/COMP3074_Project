package ca.gbc.comp3074.kenny_john.comp3074_project

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun RestaurantItem(restaurant: Restaurant) {
    Row(
        modifier = Modifier.padding(16.dp).fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            modifier = Modifier
                .padding(16.dp)
                .padding(16.dp)
        ) {
            Text(
                text = restaurant.id,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = restaurant.name,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun LazyRestaurantList(modifier: Modifier, restaurants: List<Restaurant>) {

    LazyColumn (
        modifier = modifier.padding(16.dp)
            .fillMaxSize()
    ){
        items(restaurants){
            restaurant ->
            RestaurantItem(restaurant)
            HorizontalDivider()
        }

    }
}

@Composable
fun RestaurantsScreen (modifier: Modifier) {
    val context = LocalContext.current
    val restaurants = remember { loadRestaurants(context)}

    LazyRestaurantList(modifier, restaurants)

}
