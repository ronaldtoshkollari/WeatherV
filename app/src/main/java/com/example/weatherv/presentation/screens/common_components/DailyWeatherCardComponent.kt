package com.example.weatherv.presentation.screens.common_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.weatherv.common.Constants

@Composable
fun DailyWeatherCardComponent(
    day: String,
    iconName: String,
    degree: String,
    description: String
) {

    val imageUrl = Constants.ICON_URL + iconName + ".png"

    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(0.95f)
            .height(100.dp)
    ) {

        Text(
            text = day,
            fontWeight = FontWeight.Light,
            fontSize = 20.sp,
            modifier = Modifier.align(
                Alignment.CenterStart
            )
        )

        Row(
            modifier = Modifier
                .fillMaxHeight()
                .align(Alignment.Center),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Image(
                painter = rememberImagePainter(imageUrl),
                contentDescription = "Weather Icon",
                modifier = Modifier.size(64.dp)
            )

            Spacer(modifier = Modifier.width(3.dp))

            Text(
                text = description,
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier.width(100.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )


        }

        Text(
            text = "$degree°C",
            fontWeight = FontWeight.Light,
            fontSize = 20.sp,
            modifier = Modifier.align(
                Alignment.CenterEnd
            )
        )

        Divider(color = Color.Black)

    }


}