package com.example.weatherapp.domain.weather

data class WeatherInfo(
    val weatherDataPerDay: Map<Int, List<Hourly>>,
    val currentWeatherData: Hourly?
)
