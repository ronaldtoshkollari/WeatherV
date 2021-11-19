package com.example.weatherv.domain.repository

import com.example.weatherv.domain.model.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherInfo(): WeatherInfo
    suspend fun getWeatherInfoByCityName(city: String): WeatherInfo

}