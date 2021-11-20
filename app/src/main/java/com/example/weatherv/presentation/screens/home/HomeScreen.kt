package com.example.weatherv.presentation.screens.home

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.weatherv.presentation.screens.home.components.HourlyWeatherCardComponent
import com.example.weatherv.presentation.screens.home.components.TopAppBarComponent
import com.example.weatherv.presentation.screens.home.components.WeatherCardComponent
import com.example.weatherv.presentation.screens.home.components.WeatherDetailCardComponent
import com.example.weatherv.presentation.viewmodel.MainViewModel

@Composable
fun HomeScreen(
    viewModel: MainViewModel = hiltViewModel()
) {

    val state = viewModel.state.value.weatherInfo

    Scaffold(
        topBar = {
            TopAppBarComponent(
                city = state?.city?.name ?: "Athens",
                onFavouritesClick = { /*TODO*/ },
                onSearchClick = { /*TODO*/ },
                navController = rememberNavController()
            )
        }
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            WeatherCardComponent(
                date = state?.currentWeather?.date ?: "",
                description = state?.currentWeather?.description ?: "",
                degree = state?.currentWeather?.degree ?: "",
                iconName = state?.currentWeather?.iconName ?: ""
            )

            Spacer(modifier = Modifier.height(50.dp))

            WeatherDetailCardComponent(
                wind = state?.currentWeather?.windSpeed ?: "",
                humidity = state?.currentWeather?.humidity ?: "",
                cloud = state?.currentWeather?.humidity ?: ""
            )

            Spacer(modifier = Modifier.height(20.dp))

            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Today",
                    fontWeight = FontWeight.Light,
                    fontSize = 18.sp,
                    modifier = Modifier.align(
                        Alignment.CenterStart
                    ),
                    color = Color.Black
                )

                Text(
                    text = "Next 7 Days >",
                    fontWeight = FontWeight.Thin,
                    fontSize = 18.sp,
                    modifier = Modifier.align(
                        Alignment.CenterEnd
                    ),
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {

                items(state?.hourlyWeatherInfo ?: emptyList()) {
                    HourlyWeatherCardComponent(
                        degree = it.degree,
                        iconName = it.iconName,
                        time = it.hour
                    )
                }

            }
        }

    }

}