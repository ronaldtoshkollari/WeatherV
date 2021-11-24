package com.example.weatherv.presentation.screens.week_weather

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weatherv.R
import com.example.weatherv.presentation.navigation.Screen
import com.example.weatherv.presentation.screens.common_components.CustomTopBarComponent
import com.example.weatherv.presentation.screens.common_components.DailyWeatherCardComponent
import com.example.weatherv.presentation.screens.common_components.WeatherDetailCardComponent
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
    val swipeRefreshState = rememberSwipeRefreshState(viewModel.state.value.isLoading)

    Scaffold(
        topBar = {

            CustomTopBarComponent(text = "Next 7 Days") {
                navController.popBackStack()
            }

        }) {

        if (state.weatherInfo != null) {

            val tommorowWeather = state.weatherInfo.dailyWeatherInfo.first()


            SwipeRefresh(
                state = swipeRefreshState,
                onRefresh = { viewModel.refresh() },
                refreshTriggerDistance = 200.dp
            ) {

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

                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(320.dp)
                    ) {

                        itemsIndexed(items = state.weatherInfo.dailyWeatherInfo) { index, weather ->
                            DailyWeatherCardComponent(
                                weather
                            ) { navController.navigate(route = Screen.DetailScreen.route.plus("/$index"))}
                            Divider(color = Color.Black)
                        }

//                        items(state.weatherInfo.dailyWeatherInfo) {
//                            DailyWeatherCardComponent(
//                                it
//                            ) { navController.navigate(Screen.DetailScreen.route) }
//                            Divider(color = Color.Black)
//                        }
                    }

                }

            }

        } else if (viewModel.state.value.isLoading) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        } else if (viewModel.state.value.errorOccurred) {
            SwipeRefresh(
                state = swipeRefreshState,
                onRefresh = { viewModel.refresh() },
                refreshTriggerDistance = 200.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.network_two),
                        contentDescription = "Error Icon"
                    )
                    Text(text = viewModel.state.value.message ?: "An unexpected error occurred.")
                }
            }
        }


    }


}