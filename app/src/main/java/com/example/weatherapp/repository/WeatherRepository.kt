package com.example.weatherapp.repository

import com.example.weatherapp.api.WeatherApi
import com.example.weatherapp.model.WeatherResponse
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(city: String, apiKey: String): WeatherResponse? {
        return try {
            val response = api.getWeather(city, apiKey)
            if (response.isSuccessful) {
                response.body()
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
}