package com.example.weatherv.presentation.viewmodel

import com.example.weatherv.domain.model.WeatherInfo

data class MainState(
    val weatherInfo: WeatherInfo? = null,
    val message: String? = null,
    val isLoading: Boolean = false,
    val errorOccurred: Boolean = false
)