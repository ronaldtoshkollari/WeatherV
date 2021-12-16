package com.example.weatherv.common

object Constants {

    init {
        System.loadLibrary("api-keys")
    }
    external fun getKeys(): String


    //Default values
    const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    const val LAT = 37.9838
    const val LON = 23.7275
    const val EXCLUDE = "minutely,alerts"
    val APPID = getKeys()
    const val UNITS = "metric"
    const val DEFAULT_CITY = "Athens"

    //Icons
    const val ICON_URL = "https://openweathermap.org/img/wn/"

}