package com.example.weatherv.di

import com.example.weatherv.common.Constants
import com.example.weatherv.data.api.WeatherApi
import com.example.weatherv.data.repository.CityRepositoryImpl
import com.example.weatherv.data.repository.WeatherRepositoryImpl
import com.example.weatherv.domain.repository.CityRepository
import com.example.weatherv.domain.repository.WeatherRepository
import com.example.weatherv.domain.use_case.GetCurrentWeatherUseCase
import com.example.weatherv.domain.use_case.SearchCityUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRetrofitApi(): WeatherApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }

    @Provides
    @Singleton
    fun provideWeatherRepo(weatherApi: WeatherApi): WeatherRepository {
        return WeatherRepositoryImpl(weatherApi)
    }

    @Provides
    @Singleton
    fun provideCityRepo(weatherApi: WeatherApi): CityRepository {
        return CityRepositoryImpl(weatherApi)
    }

    @Provides
    @Singleton
    fun provideGetCurrentWeatherUseCase(weatherRepository: WeatherRepository): GetCurrentWeatherUseCase {
        return GetCurrentWeatherUseCase(weatherRepository)
    }

    @Provides
    @Singleton
    fun provideSearchCityWeatherUseCase(cityRepository: CityRepository): SearchCityUseCase {
        return SearchCityUseCase(cityRepository)
    }

}