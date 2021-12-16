package com.example.weatherv.domain.repository

import com.example.weatherv.domain.model.city.City

interface CityRepository {

    suspend fun getCityCoordinates(city: String?): City
}