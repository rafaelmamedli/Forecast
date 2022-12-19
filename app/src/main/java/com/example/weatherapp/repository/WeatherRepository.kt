package com.example.weatherapp.repository

import com.example.weatherapp.api.ApiService
import javax.inject.Inject

class WeatherRepository @Inject
constructor(var apiService: ApiService) {

    suspend fun getWeather() = apiService.getWeather()

}