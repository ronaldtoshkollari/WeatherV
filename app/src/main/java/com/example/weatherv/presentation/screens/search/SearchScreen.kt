package com.example.weatherv.presentation.screens.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.weatherv.common.Constants
import com.example.weatherv.presentation.navigation.Screen
import com.example.weatherv.presentation.viewmodel.search.SearchViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    navController: NavController
) {

    val searchText = remember {
        mutableStateOf("")
    }

    val state = viewModel.state.value


    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                elevation = 5.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp),
                contentPadding = PaddingValues(all = 10.dp),
                backgroundColor = MaterialTheme.colors.background,
                contentColor = MaterialTheme.colors.onBackground
            ) {

                Row(Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically) {

                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back Icon",
                        modifier = Modifier
                            .clickable { navController.popBackStack() }
                    )

                    TextField(
                        modifier = Modifier.fillMaxSize(),
                        value = searchText.value,
                        onValueChange = { searchText.value = it },
                        placeholder = {
                            Text(
                                text = "Search city...",
                                color = Color.LightGray,
                                fontSize = 14.sp
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            textColor = Color.Black,
                            cursorColor = Color(0xFF001427),
                            focusedIndicatorColor = Color(0xFF001427)
                        ),
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Search
                        ),
                        keyboardActions = KeyboardActions(onSearch = {
                            viewModel.searchCity(
                                searchText.value
                            )
                        })

                    )


                }

            }
        }
    ) {

        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
                .clickable {
                    navController.navigate(
                        Screen.CityScreen.route
                            .plus("/${state.city?.lat}")
                            .plus("/${state.city?.lon}")
                            .plus("/${Constants.DEFAULT_CITY}")
                    )
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (state.city?.name == null) {
                Text(
                    text = "No city found",
                    color = Color.Black,
                    fontSize = 18.sp
                )
            } else {
                Card(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(15.dp),
                    backgroundColor = Color.LightGray,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(65.dp)
                ) {

                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = state.city.name,
                            color = Color.White,
                            fontSize = 24.sp,
                            modifier = Modifier.padding(10.dp)
                        )

                    }

                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Favourite Cities")

            //TODO: Implement Favourite cities

        }


    }

}