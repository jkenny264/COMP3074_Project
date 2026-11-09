package ca.gbc.comp3074.kenny_john.comp3074_project

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon

import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ca.gbc.comp3074.kenny_john.comp3074_project.ui.theme.COMP3074_ProjectTheme
import kotlin.collections.listOf

import androidx.navigation.NavType
import androidx.navigation.navArgument

import androidx.compose.runtime.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val database = AppDatabase.getDatabase(applicationContext)
        setContent {
            COMP3074_ProjectTheme {

                val viewModel: RestaurantViewModel = viewModel(
                    factory = RestaurantViewModelFactory(
                        database.restaurantDao()
                    )
                )


                RestaurantApp(viewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantApp(viewModel: RestaurantViewModel) {



    val navController = rememberNavController()

    val restaurants by viewModel.restaurants
        .collectAsStateWithLifecycle(initialValue = emptyList())


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("<Logo>") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.LightGray
                ),

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
                        navController.navigate("restaurants_search_screen")
                    },
                    onCreateRestaurantScreenClick = {
                        navController.navigate("create_restaurant_screen")
                    },
                    restaurants = restaurants
                )
            }
            composable(
                route = "restaurant_details/{id}",
                arguments = listOf(navArgument("id") {
                    type = NavType.IntType
                })
            ) { backStackEntry ->

                val id = backStackEntry.arguments!!.getInt("id")

                val restaurant by viewModel
                    .getRestaurantById(id)
                    .collectAsState(initial = null)

                RestaurantDetailsScreen(
                    modifier = Modifier,
                    restaurant = restaurant,
                    onEditRestaurantClick = {
                        navController.navigate("edit_restaurant_screen/$id")
                    }
                )
            }

            composable("create_restaurant_screen") {
                CreateRestaurantScreen(
                    modifier = Modifier,
                    onAddRestaurantClick = viewModel::addRestaurant,
                    navBack = {
                        navController.navigate("restaurants_screen")
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

                val restaurant by viewModel
                    .getRestaurantById(id)
                    .collectAsState(initial = null)


                EditRestaurantScreen(
                    modifier = Modifier,
                    restaurant = restaurant,
                    onUpdateRestaurantClick = viewModel::updateRestaurant,
                    navBack = {
                        val id = restaurant?.id
                        navController.navigate("restaurant_details/$id")
                    }
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


