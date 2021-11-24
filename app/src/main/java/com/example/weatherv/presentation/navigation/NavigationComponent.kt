package com.example.weatherv.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.weatherv.presentation.screens.details.DetailScreen
import com.example.weatherv.presentation.screens.home.HomeScreen
import com.example.weatherv.presentation.screens.splash.SplashScreen
import com.example.weatherv.presentation.screens.week_weather.WeekWeatherScreen

@Composable
fun NavigationComponent(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(route = Screen.WeekWeatherScreen.route) {
            WeekWeatherScreen(navController = navController)
        }

        composable(route = Screen.DetailScreen.route + "/{itemIndex}",
            arguments = listOf(navArgument("itemIndex") { type = NavType.IntType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt("itemIndex")
                ?.let { DetailScreen(navController = navController, weatherIndex = it) }
        }

    }

}