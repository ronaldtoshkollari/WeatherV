package com.example.weatherv.domain.mapper

import com.example.weatherv.data.api.dto.coordinates.CityCoordinatesDto
import com.example.weatherv.data.api.dto.weather_info.CurrentWeatherInfoDto
import com.example.weatherv.data.api.dto.weather_info.DailyWeatherInfoDto
import com.example.weatherv.data.api.dto.weather_info.HourlyWeatherInfoDto
import com.example.weatherv.data.api.dto.weather_info.WeatherInfoDto
import com.example.weatherv.domain.model.weather.HourlyWeather
import com.example.weatherv.domain.model.weather.Weather
import com.example.weatherv.domain.model.weather.WeatherInfo
import com.example.weatherv.utils.DateConverter

object WeatherMapper {

    private fun dailyWeatherToWeatherModel(dailyWeatherInfoDto: DailyWeatherInfoDto): Weather {
        try {

            val date = DateConverter.toDate(dailyWeatherInfoDto.dateTimeStamp) ?: ""

            return Weather(
                date = date,
                description = dailyWeatherInfoDto.weatherDetailsDto.first().description,
                degree = dailyWeatherInfoDto.temp.day.toInt().toString(),
                iconName = dailyWeatherInfoDto.weatherDetailsDto.first().icon,
                windSpeed = dailyWeatherInfoDto.wind_speed.toInt().toString(),
                humidity = dailyWeatherInfoDto.humidity.toString(),
                clouds = dailyWeatherInfoDto.clouds.toString(),
                feelsLike = dailyWeatherInfoDto.feels_like.day.toInt().toString(),
                pressure = dailyWeatherInfoDto.pressure.toString(),
                windDegree = dailyWeatherInfoDto.wind_deg.toString(),
                uvi = dailyWeatherInfoDto.uvi.toString()
            )

        } catch (e: Exception) {
            return Weather(
                date = "",
                degree = "",
                description = "",
                iconName = "",
                windSpeed = "",
                humidity = "",
                clouds = "",
                feelsLike = "",
                pressure = "",
                windDegree = "",
                uvi = ""
            )
        }
    }

    private fun hourlyWeatherToHourlyWeatherModel(hourlyWeatherInfoDto: HourlyWeatherInfoDto): HourlyWeather {

        try {
            val hour = DateConverter.toHour(hourlyWeatherInfoDto.dateTimeStamp) ?: ""

            return HourlyWeather(
                hour = hour,
                degree = hourlyWeatherInfoDto.temp.toInt().toString(),
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

    private fun currentWeatherToWeatherModel(currentWeatherInfoDto: CurrentWeatherInfoDto): Weather {
        try {

            val date = DateConverter.toDate(currentWeatherInfoDto.dateTimeStamp) ?: ""

            return Weather(
                date = date,
                description = currentWeatherInfoDto.weatherDetailDtos.first().description,
                degree = currentWeatherInfoDto.temp.toInt().toString(),
                iconName = currentWeatherInfoDto.weatherDetailDtos.first().icon,
                windSpeed = currentWeatherInfoDto.wind_speed.toInt().toString(),
                humidity = currentWeatherInfoDto.humidity.toString(),
                clouds = currentWeatherInfoDto.clouds.toString(),
                feelsLike = currentWeatherInfoDto.feels_like.toInt().toString(),
                pressure = currentWeatherInfoDto.pressure.toString(),
                windDegree = currentWeatherInfoDto.wind_deg.toString(),
                uvi = currentWeatherInfoDto.uvi.toString()
            )

        } catch (e: Exception) {
            return Weather(
                date = "",
                degree = "",
                description = "",
                iconName = "",
                windSpeed = "",
                humidity = "",
                clouds = "",
                feelsLike = "",
                pressure = "",
                windDegree = "",
                uvi = ""
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