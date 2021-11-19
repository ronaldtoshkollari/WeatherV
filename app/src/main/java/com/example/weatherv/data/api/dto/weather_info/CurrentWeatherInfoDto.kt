package com.example.weatherv.data.api.dto.weather_info

import com.google.gson.annotations.SerializedName

data class CurrentWeatherInfoDto(
    val clouds: Int,
    @SerializedName("dt")
    val dateTimeStamp: String,
    val feels_like: Double,
    val humidity: Int,
    val pressure: Int,
    val sunrise: String,
    val sunset: String,
    val temp: Double,
    val uvi: Double,
    val visibility: Int,
    @SerializedName("weather")
    val weatherDetailDtos: List<WeatherDetailsDto>,
    val wind_deg: Int,
    val wind_speed: Double
)