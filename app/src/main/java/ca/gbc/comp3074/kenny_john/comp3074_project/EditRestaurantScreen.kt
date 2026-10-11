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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun EditRestaurantTextFields(modifier: Modifier) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
//        state = rememberTextFieldState(initialText = "Hello"),
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        value = text,
        onValueChange = { text = it },
        label = { Text("Restaurant ID") }
    )

    OutlinedTextField(
//        state = rememberTextFieldState(initialText = "Hello"),
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        value = text,
        onValueChange = { text = it },
        label = { Text("Restaurant Name") }
    )

}




@Composable
fun EditRestaurantScreen (modifier: Modifier) {
    val context = LocalContext.current
    val restaurants = remember {
        mutableStateListOf<Restaurant>().apply {
            addAll(loadRestaurants(context))
        }
    }
    Column(modifier = modifier.fillMaxWidth()){

        MenuBar(modifier)

        EditRestaurantTextFields(modifier)

        Button(onClick = {
            val numRestaurants = restaurants.size
            val newRestaurant = Restaurant(
                id = "${numRestaurants + 1000}",
                name = "Restaurant ${numRestaurants + 1}"
            )
            restaurants.add(0, newRestaurant)
        },
            modifier = modifier.fillMaxWidth().padding(16.dp)) {

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Edit Restaurant")

        }

    }
}