package ca.gbc.comp3074.kenny_john.comp3074_project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EditRatingTextFields(modifier: Modifier) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
//        state = rememberTextFieldState(initialText = "Hello"),
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        value = text,
        onValueChange = { text = it },
        label = { Text("Rating ID") }
    )

    OutlinedTextField(
//        state = rememberTextFieldState(initialText = "Hello"),
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        value = text,
        onValueChange = { text = it },
        label = { Text("Rating Title") }
    )

}




@Composable
fun EditRatingScreen (modifier: Modifier) {
    val context = LocalContext.current
    val ratings = remember {
        mutableStateListOf<Rating>().apply {
            addAll(loadRatings(context))
        }
    }
    Column(modifier = modifier.fillMaxWidth()){

        MenuBar(modifier)

        EditRatingTextFields(modifier)

        Button(onClick = {
            val numRatings = ratings.size
            val newRating = Rating(
                id = "${numRatings + 1000}",
                title = "Rating ${numRatings + 1}"
            )
            ratings.add(0, newRating)
        },
            modifier = modifier.fillMaxWidth().padding(16.dp)) {

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Edit Rating")

        }

    }
}

@Preview(showBackground = true)
@Composable
fun EditRatingScreenPreview() {
    EditRatingScreen(modifier = Modifier)
}