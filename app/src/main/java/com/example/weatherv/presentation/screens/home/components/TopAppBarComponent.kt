package com.example.weatherv.presentation.screens.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun TopAppBarComponent(
    city: String,
    onFavouritesClick: () -> Unit,
    onSearchClick: () -> Unit,
    navController: NavController
) {


    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(bottomStart = 5.dp, bottomEnd = 5.dp))
            .fillMaxWidth()
            .height(95.dp)
            .background(color = MaterialTheme.colors.surface)
    ) {

        Icon(
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Favourite Icon",
            tint = MaterialTheme.colors.onSurface,
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.CenterStart)
                .padding(start = 10.dp)
        )

        Row(modifier = Modifier.align(Alignment.Center)) {

            Icon(
                imageVector = Icons.Filled.LocationOn,
                contentDescription = "Location Icon",
                tint = MaterialTheme.colors.onSurface,
                modifier = Modifier
                    .size(32.dp)
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(text = city, fontSize = 24.sp, fontWeight = FontWeight.Light, color = MaterialTheme.colors.onSurface)

        }

        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = "Search Icon",
            tint = MaterialTheme.colors.onSurface,
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.CenterEnd)
                .padding(end = 10.dp)
        )

    }


}

@Composable
@Preview(showBackground = true)
private fun Preview(){

    TopAppBarComponent(
        city = "Athens",
        {},
        {},
        rememberNavController()
    )
    
}