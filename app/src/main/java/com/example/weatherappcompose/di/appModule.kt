package com.example.weatherappcompose.di

import com.example.weatherappcompose.data.location.DefaultLocationTracker
import com.example.weatherappcompose.data.remote.WeatherApi
import com.example.weatherappcompose.data.repository.WeatherRepositoryImpl
import com.example.weatherappcompose.domain.location.LocationTracker
import com.example.weatherappcompose.domain.repository.WeatherRepository
import com.example.weatherappcompose.presentation.WeatherViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {

    single<Retrofit> { Retrofit.Builder()
        .baseUrl("https://api.open-meteo.com/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    }

    single { get<Retrofit>().create(WeatherApi::class.java) }

    single(qualifier = named("FusedLocationProviderClient")) { LocationServices.getFusedLocationProviderClient(androidContext()) }

    single<LocationTracker> { DefaultLocationTracker(get(named("FusedLocationProviderClient")), androidApplication()) }

    single<WeatherRepository> { WeatherRepositoryImpl(get()) }

    viewModel { WeatherViewModel(get(), get()) }

}