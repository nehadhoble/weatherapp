package com.example.weatherapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherapp.mainviewmodel.WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(viewModel: WeatherViewModel = hiltViewModel()) {
    val weather by viewModel.weather.collectAsState()
    val loading by viewModel.loading.collectAsState()
    val error by viewModel.error.collectAsState()

    // Fetch the weather data when the screen is first composed
    LaunchedEffect(Unit) {
        viewModel.fetchWeather("New Delhi", "4fd46e752f9502a909f32659b747e6d5")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Weather App") }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            when {
                loading -> CircularProgressIndicator()
                error != null -> Text(text = error ?: "Unknown error")
                weather != null -> {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        weather?.let {
                            Text(text = it.name)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "${it.main.temp} °C")
                        }
                    }
                }
            }
        }
    }
}
