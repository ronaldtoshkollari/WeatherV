package com.example.weatherv.presentation.screens.splash


import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.*
import com.example.weatherv.R
import com.example.weatherv.presentation.navigation.Screen
import com.example.weatherv.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {


    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.cloudy_animation))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )


    LaunchedEffect(key1 = true) {
        delay(3000L)
        navController.navigate(Screen.Home.route) {
            popUpTo(Screen.Splash.route) {
                inclusive = true
            }
        }
    }


    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        LottieAnimation(
            composition = composition, progress = progress, modifier = Modifier.align(
                Alignment.Center
            )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomStart),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Text(text = "Developed by Ronald with ",
                fontWeight = FontWeight.Thin,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.width(5.dp))

            Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Heart Icon", tint = Color.Red)

        }

    }

}

@Composable
@Preview
fun PreviewSplashScreen(){
    SplashScreen(navController = rememberNavController())
}