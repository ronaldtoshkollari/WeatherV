package com.example.weatherv.domain.use_case

import android.util.Log
import com.example.weatherv.common.Resource
import com.example.weatherv.domain.model.city.City
import com.example.weatherv.domain.model.weather.WeatherInfo
import com.example.weatherv.domain.repository.CityRepository
import com.example.weatherv.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchCityUseCase @Inject constructor(
    private val cityRepository: CityRepository
) {


    operator fun invoke(city: String): Flow<Resource<City>> = flow {

        emit(Resource.Loading<City>())

        try {

            val cityObject = cityRepository.getCityCoordinates(city)
            emit(Resource.Success<City>(cityObject))

        } catch (e: Exception) {
            Log.d("GetCurrentWeatherUseCase", "invoke: ${e.message}")
            emit(Resource.Error<City>(message = "An unexpected error occurred. Check your connection"))
        }


    }

}