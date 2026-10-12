package ca.gbc.comp3074.kenny_john.comp3074_project

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext




@Composable
fun HomeScreen (modifier: Modifier) {
    val context = LocalContext.current

    Column(modifier = modifier.fillMaxWidth()){

        MenuBar(
            modifier,
//            onHomeClick = {
//                navController.navigate("home_screen")
        )

    }


}