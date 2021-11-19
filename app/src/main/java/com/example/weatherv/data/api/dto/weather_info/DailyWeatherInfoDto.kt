package com.example.weatherv.data.api.dto.weather_info

import com.google.gson.annotations.SerializedName

data class DailyWeatherInfoDto(
    val clouds: Int,
    @SerializedName("dt")
    val dateTimeStamp: String,
    val feels_like: FeelsLike,
    val humidity: Int,
    val pressure: Int,
    val rain: Double,
    val sunrise: String,
    val sunset: String,
    val temp: Temp,
    val uvi: Double,
    @SerializedName("weather")
    val weatherDetailsDto: List<WeatherDetailsDto>,
    val wind_deg: Int,
    val wind_speed: Double
)