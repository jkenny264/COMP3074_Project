package ca.gbc.comp3074.kenny_john.comp3074_project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.gbc.comp3074.kenny_john.comp3074_project.ui.theme.COMP3074_ProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            COMP3074_ProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
/*
                    CreateRatingScreen(
                        modifier = Modifier.padding(innerPadding)
                    )

                    EditRatingScreen(
                        modifier = Modifier.padding(innerPadding)
                    )

                    CreateRestaurantScreen(
                        modifier = Modifier.padding(innerPadding)
                    )

                    EditRestaurantScreen(
                        modifier = Modifier.padding(innerPadding)
                    )

                    RestaurantsScreen(
                        modifier = Modifier.padding(innerPadding)
                    )


                    RestaurantDetailsScreen(
                        modifier = Modifier.padding(innerPadding),
                        id = 2
                    )
                    */

                    HomeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun MenuBar(modifier: Modifier) {

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray),
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

        Text(
            text = "<Logo>",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
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
fun PrgApp(modifier: Modifier) {

}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    COMP3074_ProjectTheme {
//        Greeting("Android")
//    }
//}