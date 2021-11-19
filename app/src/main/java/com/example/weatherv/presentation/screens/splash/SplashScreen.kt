package com.example.weatherv.presentation.screens.splash


import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.example.weatherv.R
import com.example.weatherv.presentation.navigation.Screen
import com.example.weatherv.presentation.viewmodel.MainViewModel
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    viewModel: MainViewModel = hiltViewModel(),
    navController: NavController
) {
    
    
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.cloudy_animation))
    val progress by animateLottieCompositionAsState(composition = composition, iterations = LottieConstants.IterateForever)


    LaunchedEffect(key1 = true){
        delay(3000L)
        navController.navigate(Screen.Home.route)
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LottieAnimation(composition = composition, progress = progress)

    }

}