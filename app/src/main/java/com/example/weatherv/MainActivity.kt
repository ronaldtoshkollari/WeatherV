package com.example.weatherv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.weatherv.presentation.navigation.NavigationComponent
import com.example.weatherv.presentation.ui.theme.WeatherVTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherVTheme {
                // A surface container using the 'background' color from the theme
                val navigation = rememberNavController()
                val systemUiController = rememberSystemUiController()

                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = Color(0xFF133C55)
                    )
                }


                Surface(color = MaterialTheme.colors.background) {

                    NavigationComponent(navController = navigation)

                }
            }
        }
    }
}
