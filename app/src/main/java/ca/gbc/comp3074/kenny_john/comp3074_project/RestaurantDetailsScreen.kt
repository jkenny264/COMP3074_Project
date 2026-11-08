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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RestaurantDetailsScreen (modifier: Modifier, restaurant: Restaurant?, onEditRestaurantClick: (Int) -> Unit, onCreateRatingClick: (Int) -> Unit) {

    Column(modifier = modifier.fillMaxWidth()){

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
                text = restaurant.address,
                fontSize = 20.sp,
                textAlign = TextAlign.Center
            )

            Button(
                onClick = {
                    onEditRestaurantClick(restaurant.id)
                },
                modifier = modifier.fillMaxWidth().padding(16.dp)) {

                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "Edit Restaurant")

            }

            Button(
                onClick = {
                    onCreateRatingClick(restaurant.id)
                },
                modifier = modifier.fillMaxWidth().padding(16.dp)) {

                Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
                Text(text = "Create Rating")
            }

        } else {
            Text(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                text = "Restaurant Not Found",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.weight(1f))



    }
}

//@Preview(showBackground = true)
//@Composable
//fun RestaurantDetailsScreenPreview() {
//    RestaurantDetailsScreen(modifier = Modifier, 1)
//}