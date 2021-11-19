package com.example.weatherv.data.api

import com.example.weatherv.common.Constants
import com.example.weatherv.data.api.dto.coordinates.CityCoordinatesDto
import com.example.weatherv.data.api.dto.weather_info.WeatherInfoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {


    @GET("onecall")
    suspend fun getWeatherInfo(
        @Query("lat") lat: Double = Constants.LAT,
        @Query("lon") lon: Double = Constants.LON,
        @Query("exclude") exclude: String = Constants.EXCLUDE,
        @Query("appid") appid: String = Constants.APPID,
        @Query("units") units: String = Constants.UNITS
    ): WeatherInfoDto

    @GET("weather")
    suspend fun getCityCoordinates(
        @Query("q") cityName: String
    ): CityCoordinatesDto
}