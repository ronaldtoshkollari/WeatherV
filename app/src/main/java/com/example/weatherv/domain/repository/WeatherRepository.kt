package com.example.weatherv.domain.repository

import com.example.weatherv.common.Constants
import com.example.weatherv.domain.model.weather.WeatherInfo

interface WeatherRepository {

    suspend fun getWeatherInfo(latitude: Double , longitude: Double = Constants.LON): WeatherInfo
    suspend fun getWeatherInfoByCityName(city: String): WeatherInfo

}