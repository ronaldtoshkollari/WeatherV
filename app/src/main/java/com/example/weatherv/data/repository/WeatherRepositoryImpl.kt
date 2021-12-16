package com.example.weatherv.data.repository

import android.util.Log
import com.example.weatherv.common.Constants
import com.example.weatherv.data.api.WeatherApi
import com.example.weatherv.domain.mapper.WeatherMapper
import com.example.weatherv.domain.model.city.City
import com.example.weatherv.domain.model.weather.HourlyWeather
import com.example.weatherv.domain.model.weather.Weather
import com.example.weatherv.domain.model.weather.WeatherInfo
import com.example.weatherv.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
) : WeatherRepository {


    override suspend fun getWeatherInfo(
        latitude: Double,
        longitude: Double
    ): WeatherInfo {

        return try {
            val response = weatherApi.getWeatherInfo()
            val cityCoordinates = weatherApi.getCityCoordinates()
            WeatherMapper.toWeatherInfo(response, cityCoordinates)
        } catch (e: Exception) {
            Log.d("WeatherRepositoryImpl", "getWeatherInfo: ${e.message}")

            val city = City(lon = Constants.LON, lat = Constants.LAT, name = Constants.DEFAULT_CITY)
            val currentWeather = Weather(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                feelsLike = "",
                pressure = "",
                windDegree = "",
                uvi = ""
            )
            val hourlyWeather = HourlyWeather("", "", "")

            WeatherInfo(city, currentWeather, listOf(currentWeather), listOf(hourlyWeather))

        }
    }


    override suspend fun getWeatherInfoByCityName(city: String): WeatherInfo {

        return try {
            val cityCoordinates = weatherApi.getCityCoordinates(city)
            val response = weatherApi.getWeatherInfo(
                lat = cityCoordinates.coordinates.lat,
                lon = cityCoordinates.coordinates.lon
            )

            WeatherMapper.toWeatherInfo(response, cityCoordinates)
        } catch (e: Exception) {
            Log.d("WeatherRepositoryImpl", "getWeatherInfoByCityName: ${e.message}")

            val cityDefaultItem =
                City(lon = Constants.LON, lat = Constants.LAT, name = Constants.DEFAULT_CITY)
            val currentWeather = Weather("", "", "", "", "", "", "", "", "", "", "")
            val hourlyWeather = HourlyWeather("", "", "")

            WeatherInfo(
                cityDefaultItem,
                currentWeather,
                listOf(currentWeather),
                listOf(hourlyWeather)
            )
        }


    }


}