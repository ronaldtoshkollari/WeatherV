package com.example.weatherv.presentation.viewmodel.main


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherv.common.Resource
import com.example.weatherv.domain.model.weather.Weather
import com.example.weatherv.domain.use_case.GetCurrentWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCurrentWeatherUseCase: GetCurrentWeatherUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MainState())
    val state: State<MainState> = _state


    init {
        getWeatherInfo()
    }


    fun getWeatherInfo() {

        getCurrentWeatherUseCase().onEach { result ->

            when (result) {

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

    fun refresh() {
        _state.value = _state.value.copy(isRefreshing = true, isLoading = true)
        getWeatherInfo()
    }

    fun getDailyWeatherWithIndex(index: Int): Weather {

        var weather = Weather(date = "", description = "", degree = "", iconName = "", windSpeed = "", humidity = "", clouds = "", feelsLike = "", pressure = "", "", "")

        state.value.weatherInfo?.dailyWeatherInfo.let {
            if (it != null) {
                weather = it[index]
            }
        }

        return weather
    }

    fun getCityWeather(lat: Double, lon: Double) {
        getCurrentWeatherUseCase(lat, lon).onEach { result ->

            when (result) {

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