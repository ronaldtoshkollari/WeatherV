package com.example.weatherv.presentation.screens.details

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weatherv.presentation.screens.common_components.CustomTopBarComponent
import com.example.weatherv.presentation.viewmodel.MainViewModel

@Composable
fun DetailScreen(
    viewModel: MainViewModel = hiltViewModel(),
    navController: NavController,
    weatherIndex: Int
) {


    Scaffold(
        topBar = {
            CustomTopBarComponent(text = "Details") {
                navController.popBackStack()
            }
        }
    ) {

        Text(text = weatherIndex.toString())

        
    }

}