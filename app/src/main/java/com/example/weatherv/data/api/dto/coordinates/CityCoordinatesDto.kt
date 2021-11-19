package com.example.weatherv.data.api.dto.coordinates

import com.google.gson.annotations.SerializedName

data class CityCoordinatesDto(
    @SerializedName("coord")
    val coordinates: CoordDto
)