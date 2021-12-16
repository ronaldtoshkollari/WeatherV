package com.example.weatherv.presentation.viewmodel.search

import com.example.weatherv.domain.model.city.City

data class SearchState(
    val city: City? = null,
    val isLoading: Boolean = false,
    val errorOccurred: Boolean = false
)
