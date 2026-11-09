package ca.gbc.comp3074.kenny_john.comp3074_project

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp





@Composable
fun EditRestaurantScreen (modifier: Modifier, restaurant: Restaurant?,
                          onUpdateRestaurantClick: (Restaurant) -> Unit,
                          navBack: () -> Unit
) {




    Column(modifier = modifier.fillMaxWidth()){
        if (restaurant != null) {

            var name by rememberSaveable { mutableStateOf(restaurant.name) }
            var address by rememberSaveable { mutableStateOf(restaurant.address) }
            var rating by rememberSaveable { mutableStateOf(restaurant.rating) }

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                value = address,
                onValueChange = { address = it },
                label = { Text("Address") }
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                value = rating,
                onValueChange = { newRating -> rating = convertRating(newRating) },
                label = { Text("Restaurant Rating") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )

            Button(
                onClick = {
                    onUpdateRestaurantClick(
                        restaurant.copy(
                            name = name,
                            address = address,
                            rating = rating
                        )
                    )
                    navBack()
                },
                modifier = modifier.fillMaxWidth().padding(16.dp)
            ) {

                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "Edit Restaurant")

            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun EditRestaurantScreenPreview() {
//    EditRestaurantScreen(modifier = Modifier, 2)
//}