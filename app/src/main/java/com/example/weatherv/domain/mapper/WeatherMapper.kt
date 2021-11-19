package com.example.weatherv.domain.mapper

import com.example.weatherv.data.api.dto.coordinates.CityCoordinatesDto
import com.example.weatherv.data.api.dto.weather_info.CurrentWeatherInfoDto
import com.example.weatherv.data.api.dto.weather_info.DailyWeatherInfoDto
import com.example.weatherv.data.api.dto.weather_info.HourlyWeatherInfoDto
import com.example.weatherv.data.api.dto.weather_info.WeatherInfoDto
import com.example.weatherv.domain.model.HourlyWeather
import com.example.weatherv.domain.model.Weather
import com.example.weatherv.domain.model.WeatherInfo
import com.example.weatherv.utils.DateConverter

object WeatherMapper {

    fun dailyWeatherToWeatherModel(dailyWeatherInfoDto: DailyWeatherInfoDto): Weather {
        try {

            val date = DateConverter.toDate(dailyWeatherInfoDto.dateTimeStamp) ?: ""

            return Weather(
                date = date,
                description = dailyWeatherInfoDto.weatherDetailsDto.first().description,
                degree = dailyWeatherInfoDto.temp.day.toString(),
                iconName = dailyWeatherInfoDto.weatherDetailsDto.first().icon,
                windSpeed = dailyWeatherInfoDto.wind_speed.toString(),
                humidity = dailyWeatherInfoDto.humidity.toString()
            )

        } catch (e: Exception) {
            return Weather(
                date = "",
                degree = "",
                description = "",
                iconName = "",
                windSpeed = "",
                humidity = ""
            )
        }
    }

    fun hourlyWeatherToHourlyWeatherModel(hourlyWeatherInfoDto: HourlyWeatherInfoDto): HourlyWeather {

        try {
            val hour = DateConverter.toHour(hourlyWeatherInfoDto.dateTimeStamp) ?: ""

            return HourlyWeather(
                hour = hour,
                degree = hourlyWeatherInfoDto.temp.toString(),
                iconName = hourlyWeatherInfoDto.weatherDetailsDto.first().icon
            )
        } catch (e: Exception) {

            return HourlyWeather(
                hour = "",
                degree = "",
                iconName = ""
            )

        }

    }

    fun currentWeatherToWeatherModel(currentWeatherInfoDto: CurrentWeatherInfoDto): Weather {
        try {

            val date = DateConverter.toDate(currentWeatherInfoDto.dateTimeStamp) ?: ""

            return Weather(
                date = date,
                description = currentWeatherInfoDto.weatherDetailDtos.first().description,
                degree = currentWeatherInfoDto.temp.toString(),
                iconName = currentWeatherInfoDto.weatherDetailDtos.first().icon,
                windSpeed = currentWeatherInfoDto.wind_speed.toString(),
                humidity = currentWeatherInfoDto.humidity.toString()
            )

        } catch (e: Exception) {
            return Weather(
                date = "",
                degree = "",
                description = "",
                iconName = "",
                windSpeed = "",
                humidity = ""
            )
        }
    }

    fun toWeatherInfo(
        weatherInfoDto: WeatherInfoDto,
        cityCoordinatesDto: CityCoordinatesDto
    ): WeatherInfo {
        return WeatherInfo(
            city = CityMapper.cityCoordinatesToCity(cityCoordinatesDto = cityCoordinatesDto),
            currentWeather = currentWeatherToWeatherModel(weatherInfoDto.currentWeatherInfoDto),
            dailyWeatherInfo = weatherInfoDto.dailyWeatherInfoDto.map {
                dailyWeatherToWeatherModel(
                    it
                )
            },
            hourlyWeatherInfo = weatherInfoDto.hourlyWeatherInfoDto.map {
                hourlyWeatherToHourlyWeatherModel(
                    it
                )
            })
    }

}