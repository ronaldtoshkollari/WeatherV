package com.example.weatherv.presentation.viewmodel.main

import com.example.weatherv.domain.model.weather.WeatherInfo

data class MainState(
    val weatherInfo: WeatherInfo? = null,
    val message: String? = null,
    val isLoading: Boolean = false,
    val errorOccurred: Boolean = false,
    val isRefreshing: Boolean = false
)