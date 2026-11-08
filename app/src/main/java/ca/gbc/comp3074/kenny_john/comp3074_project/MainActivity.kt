package ca.gbc.comp3074.kenny_john.comp3074_project

import android.content.Intent
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon

import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ca.gbc.comp3074.kenny_john.comp3074_project.ui.theme.COMP3074_ProjectTheme
import kotlin.collections.listOf

import androidx.navigation.NavType
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            COMP3074_ProjectTheme {
                RestaurantApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantApp() {
    val navController = rememberNavController()


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("<Logo>") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.LightGray
                ),
//                navigationIcon = {
//                    IconButton(
//                        onClick = {
//                            navController.popBackStack()
//                        }
//                    ) {
//                        Icon(
//                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
//                            contentDescription = "Back"
//                        )
//                    }
//
//                },

                actions = {
                    IconButton(
                        onClick = {
                            navController.navigate("home_screen") {
                                popUpTo("home_screen") {
                                    inclusive = false
                                }
                                launchSingleTop = true
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->



        NavHost(
            navController = navController,
            startDestination = "home_screen",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home_screen") {
                HomeScreen(
                    modifier = Modifier,
                    onRestaurantsClick = {
                        navController.navigate("restaurants_screen")
                    },
                    onAboutClick = {
                        navController.navigate("about_screen")
                    }
                )
            }

            composable("about_screen") {
                AboutScreen(
                    modifier = Modifier
                )
            }
            composable("restaurants_screen") {
                RestaurantsScreen(
                    modifier = Modifier,
                    onRestaurantDetailsClick = { id ->
                        navController.navigate("restaurant_details/$id")
                    },
                    onRestaurantsSearchClick = {
                        navController.navigate("restaurant_details")
                    }
                )
            }
            composable(
                route = "restaurant_details/{id}",
                arguments = listOf(navArgument("id") {
                    type = NavType.IntType
                })
            ) { backStackEntry ->

                val id = backStackEntry.arguments!!.getInt("id")

                RestaurantDetailsScreen(
                    modifier = Modifier,
                    id = id,
                    onEditRestaurantClick = {
                        navController.navigate("edit_restaurant_screen/$id")
                    },
                    onCreateRatingClick = {
                        navController.navigate("create_rating_screen/$id")
                    }
                )
            }
            composable(
                route = "edit_restaurant_screen/{id}",
                arguments = listOf(navArgument("id") {
                    type = NavType.IntType
                })
            ) { backStackEntry ->

                val id = backStackEntry.arguments!!.getInt("id")

                EditRestaurantScreen(
                    modifier = Modifier,
                    id = id
                )
            }

            composable(
                route = "create_rating_screen/{id}",
                arguments = listOf(navArgument("id") {
                    type = NavType.IntType
                })
            ) { backStackEntry ->

                val id = backStackEntry.arguments!!.getInt("id")

                CreateRatingScreen(
                    modifier = Modifier,
                    restaurantId = id
                )
            }

//            composable("restaurants_search_screen") {
//                RestaurantsSearchScreen(
//                    modifier = Modifier
//                )
//            }

        }


    }


}


