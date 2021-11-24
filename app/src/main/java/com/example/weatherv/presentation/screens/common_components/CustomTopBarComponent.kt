package com.example.weatherv.presentation.screens.common_components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTopBarComponent(
    text: String,
    onBackClick: () -> Unit
) {

    TopAppBar(
        elevation = 5.dp,
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp),
        contentPadding = PaddingValues(all = 10.dp),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground
    ) {

        Box(Modifier.fillMaxSize()) {

            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back Icon",
                modifier = Modifier
                    .align(
                        Alignment.CenterStart
                    )
                    .clickable { onBackClick() }
            )

            Text(
                text = text,
                fontSize = 28.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.align(
                    Alignment.Center
                )
            )

        }

    }

}