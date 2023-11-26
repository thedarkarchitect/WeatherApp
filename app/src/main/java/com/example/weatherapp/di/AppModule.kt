package com.example.weatherapp.di

import android.app.Application
import com.example.weatherapp.data.remote.WeatherAPi
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideWeatherApi() : WeatherAPi {
        return Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherAPi::class.java)
    }

    @Provides
    @Singleton
    fun provideFusedLocationProvideClient(app: Application): FusedLocationProviderClient{
        return LocationServices.getFusedLocationProviderClient(app)
    }
}