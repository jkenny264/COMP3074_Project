package ca.gbc.comp3074.kenny_john.comp3074_project

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun RestaurantsSearchScreen (modifier: Modifier) {
    val context = LocalContext.current
    val restaurants = remember { loadRestaurants(context)}
    var text by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxWidth()){

        MenuBar(modifier)
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            value = text,
            onValueChange = { text = it },
            label = { Text("Restaurant Name") }
        )
        Button(onClick = {},
            modifier = modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Search")

        }
        LazyRestaurantList(modifier, restaurants)
    }

}
