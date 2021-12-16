package com.example.weatherv.data.api.dto.weather_info

import com.google.gson.annotations.SerializedName

data class WeatherInfoDto(

    @SerializedName("current")
    val currentWeatherInfoDto: CurrentWeatherInfoDto,

    @SerializedName("daily")
    val dailyWeatherInfoDto: List<DailyWeatherInfoDto>,

    @SerializedName("hourly")
    val hourlyWeatherInfoDto: List<HourlyWeatherInfoDto>,

    val lat: Double,
    val lon: Double
)