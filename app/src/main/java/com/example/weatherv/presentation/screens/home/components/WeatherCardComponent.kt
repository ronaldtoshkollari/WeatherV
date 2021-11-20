package com.example.weatherv.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.weatherv.common.Constants

@Composable
fun WeatherCardComponent(
    date: String,
    description: String,
    degree: String,
    iconName: String
) {

    val brush = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF133C55),
            Color.White
        )
    )

    val iconUrl = "${Constants.ICON_URL}$iconName.png"

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(80.dp))
            .background(brush = brush)
            .width(250.dp)
            .height(260.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Text(
            text = date,
            color = MaterialTheme.colors.onSurface,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 27.dp)
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = description.replaceFirstChar { it.uppercase() },
            color = MaterialTheme.colors.onSurface,
            fontWeight = FontWeight.Light,
            fontSize = 26.sp
        )

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = "${degree}°C",
            color = MaterialTheme.colors.onSurface,
            fontWeight = FontWeight.Normal,
            fontSize = 36.sp
        )

        Spacer(modifier = Modifier.height(14.dp))


        Image(painter = rememberImagePainter(iconUrl), contentDescription = "Weather Icon", Modifier.size(64.dp))

    }

}

@Preview
@Composable
private fun Preview(){
    WeatherCardComponent(
        date = "Friday, 19 November",
        description = "Rain",
        degree = "25",
        iconName = "10d"
    )
}