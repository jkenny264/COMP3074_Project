package ca.gbc.comp3074.kenny_john.comp3074_project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        item {
            Text(
                text = "Restaurants",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
        items(restaurants){
            restaurant ->
            RestaurantItem(restaurant)
            HorizontalDivider()
        }

    }
}

@Composable
fun MenuBar(modifier: Modifier) {

    Row(modifier = modifier.fillMaxWidth().background(Color.LightGray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {
                //
            },
            modifier = modifier.padding(horizontal = 32.dp)
        ) {
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Back")
        }
        Button(
            onClick = {
                //
            },
            modifier = modifier.padding(horizontal = 32.dp)
        ) {

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Home")
        }
    }
}

@Composable
fun RestaurantsScreen (modifier: Modifier) {
    val context = LocalContext.current
    val restaurants = remember { loadRestaurants(context)}


//    Column() {
//        Button(onClick = {}) {
//            Text(text = "back")
//            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
//        }
//    }
//    LazyRestaurantList(modifier, restaurants)

    Column(modifier = modifier.fillMaxWidth()){

        MenuBar(modifier)
        LazyRestaurantList(modifier, restaurants)

    }


}
