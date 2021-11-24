package com.example.weatherv.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.weatherv.presentation.screens.home.components.HourlyWeatherCardComponent
import com.example.weatherv.presentation.screens.home.components.TopAppBarComponent
import com.example.weatherv.presentation.screens.home.components.WeatherCardComponent
import com.example.weatherv.presentation.screens.common_components.WeatherDetailCardComponent
import com.example.weatherv.R
import com.example.weatherv.presentation.navigation.Screen
import com.example.weatherv.presentation.viewmodel.MainViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun HomeScreen(
    viewModel: MainViewModel = hiltViewModel(),
    navController: NavController
) {

    val state = viewModel.state.value.weatherInfo
    val swipeRefreshState = rememberSwipeRefreshState(viewModel.state.value.isLoading)

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


        if (viewModel.state.value.isLoading) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator()
            }
        } else if (!viewModel.state.value.isLoading && !viewModel.state.value.errorOccurred) {
            SwipeRefresh(
                state = swipeRefreshState,
                onRefresh = { viewModel.refresh() },
                refreshTriggerDistance = 200.dp
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
                        cloud = state?.currentWeather?.clouds ?: ""
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
                            modifier = Modifier
                                .align(
                                    Alignment.CenterEnd
                                )
                                .clickable { navController.navigate(Screen.WeekWeatherScreen.route) },
                            color = Color.Black
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

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