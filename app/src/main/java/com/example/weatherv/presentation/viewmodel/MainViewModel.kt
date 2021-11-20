package com.example.weatherv.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherv.common.Resource
import com.example.weatherv.domain.model.WeatherInfo
import com.example.weatherv.domain.use_case.GetCurrentWeatherUseCase
import com.example.weatherv.domain.use_case.SearchCityWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase,
    private val searchCityWeatherUseCase: SearchCityWeatherUseCase
): ViewModel() {

    private val _state = mutableStateOf(MainState())
    val state: State<MainState> = _state


    init {
        getWeatherInfo()
    }


    private fun getWeatherInfo() {

        getCurrentWeatherUseCase().onEach { result ->

            when(result) {

                is Resource.Loading -> {
                    _state.value = MainState(message = "Loading...", isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = MainState(message = "An error occurred.", errorOccurred = true)
                }

                is Resource.Success -> {
                    _state.value = MainState(weatherInfo = result.data)
                }

            }

        }.launchIn(viewModelScope)

    }

}