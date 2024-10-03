package com.example.weatherapp.model

import com.google.gson.annotations.SerializedName


data class WeatherResponse(
    @SerializedName("name") val name: String,
    @SerializedName("main") val main: Main
) {
    data class Main(
        @SerializedName("temp") val temp: Double
    )
}