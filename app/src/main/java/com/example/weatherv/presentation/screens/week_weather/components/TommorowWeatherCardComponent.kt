package com.example.weatherv.presentation.screens.week_weather.components

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.weatherv.common.Constants

@Composable
fun TommorowWeatherCardComponent(
    iconName: String,
    degree: String,
    description: String
) {

    val brush = Brush.verticalGradient(
        colors = listOf(
            Color.White,
            Color(0xFF009DE0)
        )
    )

    val iconUrl = Constants.ICON_URL + iconName + ".png"

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(32.dp))
            .widthIn(min = 550.dp)
            .fillMaxWidth(0.7f)
            .height(180.dp)
            .background(brush = brush)
    ) {

        Image(
            painter = rememberImagePainter(iconUrl),
            contentDescription = "Weather Icon",
            modifier = Modifier
                .padding(start = 30.dp)
                .size(72.dp)
                .align(
                    Alignment.CenterStart
                )
        )

        Column(
            modifier = Modifier
                .padding(end = 30.dp)
                .width(150.dp)
                .height(150.dp)
                .align(Alignment.CenterEnd),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            
            Text(text = "Tommorow", fontSize = 28.sp, color = Color.White)

            Text(text = "$degree°C", fontSize = 28.sp, color = Color.White)

            Text(text = description, fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Light)



        }


    }

}

@Preview
@Composable
private fun Preview(){
    TommorowWeatherCardComponent(
        iconName = "",
        degree = "12",
        description = "Rainy"
    )
}