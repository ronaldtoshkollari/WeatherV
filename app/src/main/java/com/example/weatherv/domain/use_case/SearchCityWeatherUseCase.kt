package com.example.weatherv.domain.use_case

import android.util.Log
import com.example.weatherv.common.Resource
import com.example.weatherv.domain.model.WeatherInfo
import com.example.weatherv.domain.repository.WeatherRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchCityWeatherUseCase @Inject constructor(
    private val weatherRepository: WeatherRepository
) {


    operator fun invoke(city: String): Flow<Resource<WeatherInfo>> = flow {

        emit(Resource.Loading<WeatherInfo>())

        try {

            val weather = weatherRepository.getWeatherInfoByCityName(city)
            emit(Resource.Success<WeatherInfo>(weather))

        } catch (e: Exception) {
            Log.d("GetCurrentWeatherUseCase", "invoke: ${e.message}")
            emit(Resource.Error<WeatherInfo>(message = "An unexpected error occurred. Check your connection"))
        }


    }

}