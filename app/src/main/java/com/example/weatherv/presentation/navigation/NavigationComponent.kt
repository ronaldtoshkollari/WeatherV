package com.example.weatherv.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherv.presentation.screens.home.HomeScreen
import com.example.weatherv.presentation.screens.splash.SplashScreen

@Composable
fun NavigationComponent(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(route = Screen.Home.route) {
            HomeScreen()
        }

        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

    }

}