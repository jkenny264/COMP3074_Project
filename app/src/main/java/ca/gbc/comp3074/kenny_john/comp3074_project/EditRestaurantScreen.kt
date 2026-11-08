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
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp





@Composable
fun EditRestaurantScreen (modifier: Modifier, restaurant: Restaurant, onUpdateRestaurantClick: (Restaurant) -> Unit) {




    Column(modifier = modifier.fillMaxWidth()){

        var name by rememberSaveable { mutableStateOf("") }
        var address by rememberSaveable { mutableStateOf("") }

        Text(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            text = "Restaurant ID: " + restaurant.id.toString()
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            value = name,
            onValueChange = { name = it },
            label = { Text("Restaurant ID") }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            value = address,
            onValueChange = { address = it },
            label = { Text("Restaurant Name") }
        )

        Button(onClick = {
            onUpdateRestaurantClick(
                restaurant.copy(
                    name = name,
                    address = address
                )
            )
        },
            modifier = modifier.fillMaxWidth().padding(16.dp)) {

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Edit Restaurant")

        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun EditRestaurantScreenPreview() {
//    EditRestaurantScreen(modifier = Modifier, 2)
//}