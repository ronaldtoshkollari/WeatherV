package com.example.weatherv.presentation.navigation

sealed class Screen(val route: String){

    object Home: Screen(route = "home")
    object Splash: Screen(route = "splash")
    object WeekWeatherScreen: Screen(route = "weekWeather")
    object DetailScreen: Screen(route = "details")
    object SearchScreen: Screen(route = "search")
    object CityScreen: Screen(route = "cityWeather")

}
