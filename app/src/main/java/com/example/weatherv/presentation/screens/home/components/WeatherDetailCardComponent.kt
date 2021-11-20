package com.example.weatherv.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Air
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.Water
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeatherDetailCardComponent(
    wind: String,
    humidity: String,
    cloud: String
) {

    Card(
        elevation = 5.dp, modifier = Modifier
            .width(400.dp)
            .height(110.dp)
            .background(color = MaterialTheme.colors.surface)
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            Column(
                modifier = Modifier
                    .width(75.dp)
                    .height(95.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Icon(
                    imageVector = Icons.Filled.Air,
                    contentDescription = "Air Icon",
                    modifier = Modifier.size(32.dp),
                    tint = MaterialTheme.colors.onSurface
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "$wind m/h",
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onSurface
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "Wind",
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onSurface
                )

            }

            Column(
                modifier = Modifier
                    .width(75.dp)
                    .height(95.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Icon(
                    imageVector = Icons.Default.Water,
                    contentDescription = "Water Icon",
                    modifier = Modifier.size(32.dp),
                    tint = MaterialTheme.colors.onSurface
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "$humidity%",
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onSurface
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "Humidity",
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onSurface
                )

            }

            Column(
                modifier = Modifier
                    .width(75.dp)
                    .height(95.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Icon(
                    imageVector = Icons.Default.Cloud,
                    contentDescription = "Cloud Icon",
                    modifier = Modifier.size(32.dp),
                    tint = MaterialTheme.colors.onSurface
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "$cloud%",
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onSurface
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "Cloud",
                    fontWeight = FontWeight.Normal,
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onSurface
                )

            }


        }


    }

}

@Preview
@Composable
private fun Preview() {
    WeatherDetailCardComponent(wind = "9", humidity = "30", cloud = "60")
}
