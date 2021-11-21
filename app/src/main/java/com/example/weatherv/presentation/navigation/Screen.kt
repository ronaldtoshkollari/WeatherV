package com.example.weatherv.presentation.navigation

sealed class Screen(val route: String){

    object Home: Screen(route = "home")
    object Splash: Screen(route = "splash")
    object WeekWeatherScreen: Screen(route = "weekWeather")

}
