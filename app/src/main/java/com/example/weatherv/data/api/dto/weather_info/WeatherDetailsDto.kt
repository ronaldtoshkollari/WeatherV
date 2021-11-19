package com.example.weatherv.data.api.dto.weather_info

data class WeatherDetailsDto(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)