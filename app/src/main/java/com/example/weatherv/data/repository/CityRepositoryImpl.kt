package com.example.weatherv.data.repository

import android.util.Log
import com.example.weatherv.common.Constants
import com.example.weatherv.data.api.WeatherApi
import com.example.weatherv.domain.mapper.CityMapper
import com.example.weatherv.domain.model.City
import com.example.weatherv.domain.repository.CityRepository
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
): CityRepository{


    override suspend fun getCityCoordinates(city: String?): City {

        try {

            return if(city.isNullOrEmpty()){

                val response = weatherApi.getCityCoordinates()
                CityMapper.cityCoordinatesToCity(response)

            }else {
                val response = weatherApi.getCityCoordinates(city)
                CityMapper.cityCoordinatesToCity(response)
            }

        }catch (e: Exception){
            Log.d("CityRepoImpl", "getCityCoordinates: ${e.message}")
            return City(Constants.LON, Constants.LAT, Constants.DEFAULT_CITY)
        }

    }


}