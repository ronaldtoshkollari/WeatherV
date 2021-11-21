package com.example.weatherv.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.weatherv.common.Constants

@Composable
fun HourlyWeatherCardComponent(
    degree: String,
    iconName: String,
    time: String
) {


    val iconUrl = "${Constants.ICON_URL}$iconName.png"

    Card(
        elevation = 5.dp,
        modifier = Modifier
            .clip(RoundedCornerShape(32.dp))
            .width(130.dp)
            .height(155.dp)
            .padding(15.dp),
        backgroundColor = MaterialTheme.colors.background
    ) {

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .background(color = MaterialTheme.colors.background, shape = RoundedCornerShape(32.dp))
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Text(
                text = "$degree°C",
                color = Color.Black,
                fontSize = 24.sp,
                fontWeight = FontWeight.Light
            )


            Image(
                painter = rememberImagePainter(iconUrl),
                contentDescription = "Weather Icon",
                modifier = Modifier.size(40.dp)
            )


            Text(
                text = time,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Thin
            )


        }


    }

}


@Preview
@Composable
private fun Preview() {

    HourlyWeatherCardComponent(
        degree = "26",
        iconName = "",
        time = "13:00"
    )


}