package com.example.weatherv.data.api.dto.weather_info

import com.google.gson.annotations.SerializedName

data class HourlyWeatherInfoDto(
    val clouds: Int,
    @SerializedName("dt")
    val dateTimeStamp: String,
    val temp: Double,
    @SerializedName("weather")
    val weatherDetailsDto: List<WeatherDetailsDto>,
)