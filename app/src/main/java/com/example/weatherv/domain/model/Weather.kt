package com.example.weatherv.domain.model

data class Weather(
    val date: String,
    val description: String,
    val degree: String,
    val iconName: String,
    val windSpeed: String,
    val humidity: String
)
