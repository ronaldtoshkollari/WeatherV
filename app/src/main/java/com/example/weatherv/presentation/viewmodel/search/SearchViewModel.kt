package com.example.weatherv.presentation.viewmodel.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherv.common.Resource
import com.example.weatherv.domain.use_case.SearchCityUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchCityUseCase: SearchCityUseCase
): ViewModel() {

    private val _state = mutableStateOf(SearchState())
    val state: State<SearchState> = _state


    fun searchCity(city: String) {

        searchCityUseCase(city).onEach { resource ->

            when(resource){

                is Resource.Loading -> {
                    _state.value = SearchState(city = null, isLoading = true)
                }

                is Resource.Error -> {
                    _state.value = SearchState(city = null, errorOccurred = true)
                }

                is Resource.Success -> {
                    _state.value = SearchState(city = resource.data)
                }
            }

        }.launchIn(viewModelScope)

    }


}