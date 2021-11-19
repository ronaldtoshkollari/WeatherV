package com.example.weatherv.domain.model

data class WeatherInfo(
    val city: City,
    val currentWeather: Weather,
    val dailyWeatherInfo: List<Weather>,
    val hourlyWeatherInfo: List<HourlyWeather>
)
