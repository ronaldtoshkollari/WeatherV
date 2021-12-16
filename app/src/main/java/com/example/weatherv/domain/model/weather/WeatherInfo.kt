package com.example.weatherv.domain.model.weather

import com.example.weatherv.domain.model.city.City

data class WeatherInfo(
    val city: City,
    val currentWeather: Weather,
    val dailyWeatherInfo: List<Weather>,
    val hourlyWeatherInfo: List<HourlyWeather>
)
