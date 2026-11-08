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
fun CreateRestaurantScreen (modifier: Modifier,
                            restaurants: List<Restaurant>,
                            onAddRestaurantClick: (String, String) -> Unit
) {

    var name by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }

    Column(modifier = modifier.fillMaxWidth()){

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            value = name,
            onValueChange = { name = it },
            label = { Text("Restaurant Name") }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            value = address,
            onValueChange = { address = it },
            label = { Text("Restaurant Address") }
        )
        Button(onClick = {
            onAddRestaurantClick(
                name,
                address
            )
        },
        modifier = modifier.fillMaxWidth().padding(16.dp)) {

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Add Restaurant")

        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun CreateRestaurantScreenPreview() {
//    CreateRestaurantScreen(modifier = Modifier)
//}