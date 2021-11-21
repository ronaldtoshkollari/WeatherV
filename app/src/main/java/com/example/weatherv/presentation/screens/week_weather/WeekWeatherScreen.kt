package com.example.weatherv.presentation.screens.week_weather

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weatherv.domain.model.WeatherInfo
import com.example.weatherv.presentation.navigation.Screen
import com.example.weatherv.presentation.screens.common_components.DailyWeatherCardComponent
import com.example.weatherv.presentation.screens.common_components.WeatherDetailCardComponent
import com.example.weatherv.presentation.screens.home.components.WeatherCardComponent
import com.example.weatherv.presentation.screens.week_weather.components.TommorowWeatherCardComponent
import com.example.weatherv.presentation.viewmodel.MainViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun WeekWeatherScreen(
    viewModel: MainViewModel = hiltViewModel(),
    navController: NavController
) {


    val state = viewModel.state.value

    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 5.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp),
                contentPadding = PaddingValues(all = 10.dp),
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.onBackground
            ) {

                Box(Modifier.fillMaxSize()) {

                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Icon",
                        modifier = Modifier
                            .align(
                                Alignment.CenterStart
                            )
                            .clickable { navController.popBackStack() }
                    )

                    Text(
                        text = "Next 7 Days",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.align(
                            Alignment.Center
                        )
                    )

                }

            }
        }) {

        if (state.weatherInfo != null) {

            val tommorowWeather = state.weatherInfo.dailyWeatherInfo.first()
            val swipeRefreshState = rememberSwipeRefreshState(viewModel.state.value.isLoading)

            SwipeRefresh(state = swipeRefreshState, onRefresh = { viewModel.refresh() }) {

                Column(
                    Modifier
                        .padding(10.dp)
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    TommorowWeatherCardComponent(
                        iconName = tommorowWeather.iconName,
                        degree = tommorowWeather.degree,
                        description = tommorowWeather.description.replaceFirstChar { it.uppercase() }
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    WeatherDetailCardComponent(
                        wind = tommorowWeather.windSpeed,
                        humidity = tommorowWeather.humidity,
                        cloud = tommorowWeather.clouds
                    )

                    Spacer(modifier = Modifier.height(30.dp))

                    LazyColumn() {
                        items(state.weatherInfo.dailyWeatherInfo) {
                            DailyWeatherCardComponent(
                                day = it.date.take(3),
                                iconName = it.iconName,
                                degree = it.degree,
                                description = it.description.replaceFirstChar { it.uppercase() }
                            )
                        }
                    }

                }

            }

        }


    }


}