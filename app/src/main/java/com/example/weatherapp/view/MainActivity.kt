package com.example.weatherapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.activity.viewModels

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  val viewModel: WeatherViewModel by viewModels()  // var ile error, elave implemantion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.e("my tag","log test")

        viewModel.weatherResp.observe(this) { weather ->

         binding.apply {
             tvCityName.text = "Baku"
             tvTemperature.text =  weather.temperature
             tvWind.text = weather.wind


             val forecast = weather.forecast
             tvForecast1.text = "${forecast[0].temperature}/ ${forecast[0].wind}"
             tvForecast2.text = "${forecast[1].temperature}/ ${forecast[1].wind}"
             tvForecast3.text = "${forecast[2].temperature}/ ${forecast[2].wind}"


         }
        }


    }}