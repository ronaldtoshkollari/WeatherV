package com.example.weatherv.domain.model.weather

data class Weather(
    val date: String,
    val description: String,
    val degree: String,
    val iconName: String,
    val windSpeed: String,
    val humidity: String,
    val clouds: String,
    val feelsLike: String,
    val pressure: String,
    val windDegree: String,
    val uvi: String
)
