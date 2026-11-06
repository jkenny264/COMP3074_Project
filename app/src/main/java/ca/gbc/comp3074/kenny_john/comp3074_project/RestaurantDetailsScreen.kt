package ca.gbc.comp3074.kenny_john.comp3074_project
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RestaurantDetailsTextFields(modifier: Modifier, id: Int) {
    val context = LocalContext.current
    val restaurant = loadRestaurantById(context, id)

    if (restaurant != null) {
        Text(
            modifier = Modifier.fillMaxWidth().padding(16.dp, top=48.dp),
            text = restaurant.name,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            text = restaurant.rating,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    } else {
        Text(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            text = "Restaurant Not Found",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun RestaurantDetailsScreen (modifier: Modifier, id: Int) {
    Column(modifier = modifier.fillMaxWidth()){

        MenuBar(modifier)

        RestaurantDetailsTextFields(modifier, id)

        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {},
            modifier = modifier.fillMaxWidth().padding(16.dp)) {

            Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Edit Restaurant")

        }

    }
}

@Preview(showBackground = true)
@Composable
fun RestaurantDetailsScreenPreview() {
    RestaurantDetailsScreen(modifier = Modifier, 1)
}