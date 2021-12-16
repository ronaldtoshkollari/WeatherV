package com.example.weatherv.presentation.screens.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weatherv.presentation.screens.common_components.CustomTopBarComponent
import com.example.weatherv.presentation.viewmodel.main.MainViewModel

@Composable
fun DetailScreen(
    viewModel: MainViewModel = hiltViewModel(),
    navController: NavController,
    weatherIndex: Int
) {


    val weather = viewModel.getDailyWeatherWithIndex(index = weatherIndex)

    Scaffold(
        topBar = {
            CustomTopBarComponent(text = "Details", isCityScreen = false) {
                navController.popBackStack()
            }
        }
    ) {


        Column(
            modifier = Modifier
                .padding(22.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            Text(
                text = weather.date,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 24.sp
            )


            Divider(color = Color.Black, modifier = Modifier.padding(top = 22.dp, bottom = 22.dp))


            CustomInfo(
                startTitle = "Temp",
                startInfo = weather.degree + "°C",
                endTitle = "Feels Like",
                endInfo = weather.feelsLike + "°C"
            )

            Divider(color = Color.Black, modifier = Modifier.padding(top = 22.dp, bottom = 22.dp))

            CustomInfo(
                startTitle = "Pressure",
                startInfo = weather.pressure,
                endTitle = "Humidity",
                endInfo = weather.humidity
            )

            Divider(color = Color.Black, modifier = Modifier.padding(top = 22.dp, bottom = 22.dp))

            CustomInfo(
                startTitle = "Clouds",
                startInfo = weather.clouds,
                endTitle = "Wind Speed",
                endInfo = weather.windSpeed
            )

            Divider(color = Color.Black, modifier = Modifier.padding(top = 22.dp, bottom = 22.dp))

            CustomInfo(
                startTitle = "Wind Degrees",
                startInfo = weather.windDegree,
                endTitle = "UVI",
                endInfo = weather.uvi
            )


        }

    }

}

@Composable
private fun InfoColumn(
    modifier: Modifier,
    title: String,
    info: String
) {

    Column(
        modifier = modifier
            .width(150.dp)
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = title, fontSize = 22.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = info)

    }

}

@Composable
private fun CustomInfo(
    startTitle: String,
    startInfo: String,
    endTitle: String,
    endInfo: String
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {

        InfoColumn(
            modifier = Modifier.align(Alignment.CenterStart),
            title = startTitle,
            info = startInfo
        )

        InfoColumn(modifier = Modifier.align(Alignment.CenterEnd), title = endTitle, info = endInfo)

    }

}