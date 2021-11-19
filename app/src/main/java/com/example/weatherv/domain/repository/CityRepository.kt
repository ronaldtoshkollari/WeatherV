package com.example.weatherv.domain.repository

import com.example.weatherv.domain.model.City

interface CityRepository {

    suspend fun getCityCoordinates(city: String?): City
}