import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.weatherv.common.Constants
import com.example.weatherv.presentation.screens.common_components.CustomTopBarComponent
import com.example.weatherv.presentation.viewmodel.main.MainViewModel


@Composable
fun CityScreen(
    lat: Double,
    lon: Double,
    cityName: String,
    viewModel: MainViewModel = hiltViewModel(),
    navController: NavController
) {

    //viewModel.getCityWeather(lat, lon)
    val state = viewModel.state.value
    val iconName = state.weatherInfo?.currentWeather?.iconName ?: ""
    val iconUrl = Constants.ICON_URL + iconName + ".png"


    Scaffold(
        topBar = {
            CustomTopBarComponent(text = cityName, isCityScreen = true) {
                navController.popBackStack()
            }
        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(430.dp)
                    .background(
                        color = MaterialTheme.colors.surface,
                        shape = RoundedCornerShape(bottomEnd = 12.dp, bottomStart = 12.dp)
                    )
            ) {

                Box(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        .height(120.dp)
                ) {

                    Text(
                        text = state.weatherInfo?.currentWeather?.degree + "°C",
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.CenterStart)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxHeight()
                            .align(Alignment.CenterEnd),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = state.weatherInfo?.currentWeather?.description ?: "",
                            color = Color.White,
                            fontSize = 18.sp
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = state.weatherInfo?.currentWeather?.date ?: "",
                            color = Color.White,
                            fontSize = 14.sp
                        )


                    }

                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Image(
                        painter = rememberImagePainter(iconUrl),
                        contentDescription = "Weather Icons"
                    )

                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {

                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .height(40.dp)
                            .width(150.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White
                        ),
                        shape = RoundedCornerShape(20.dp)
                    ) {

                        Text(
                            text = "Details",
                            fontSize = 18.sp,
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colors.surface,
                            fontWeight = FontWeight.Light
                        )
                    }

                }


            }

        }


    }

}
