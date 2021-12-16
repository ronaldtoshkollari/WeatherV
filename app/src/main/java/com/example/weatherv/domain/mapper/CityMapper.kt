package com.example.weatherv.domain.mapper

import com.example.weatherv.data.api.dto.coordinates.CityCoordinatesDto
import com.example.weatherv.domain.model.city.City

object CityMapper {

    fun cityCoordinatesToCity(cityCoordinatesDto: CityCoordinatesDto): City {

        return City(
            lon = cityCoordinatesDto.coordinates.lon,
            lat = cityCoordinatesDto.coordinates.lat,
            name = cityCoordinatesDto.name
        )
    }

}