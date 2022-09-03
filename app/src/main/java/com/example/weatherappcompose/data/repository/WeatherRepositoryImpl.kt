package com.example.weatherappcompose.data.repository

import com.example.weatherappcompose.data.mappers.toWeatherInfo
import com.example.weatherappcompose.data.remote.WeatherApi
import com.example.weatherappcompose.domain.repository.WeatherRepository
import com.example.weatherappcompose.domain.util.Resource
import com.example.weatherappcompose.domain.weather.WeatherInfo
import java.lang.Exception

class WeatherRepositoryImpl(
    private val api: WeatherApi
): WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        }catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }
}