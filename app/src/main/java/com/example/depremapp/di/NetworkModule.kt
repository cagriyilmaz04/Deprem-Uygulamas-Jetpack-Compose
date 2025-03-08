package com.example.depremapp.di

import com.example.depremapp.data.api.EarthquakeApi
import com.example.depremapp.data.repository.EarthquakeRepositoryImpl
import com.example.depremapp.domain.repository.EarthquakeRepository
import com.example.depremapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideEarthquakeApi(retrofit: Retrofit): EarthquakeApi {
        return retrofit.create(EarthquakeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideEarthquakeRepository(api: EarthquakeApi): EarthquakeRepository {
        return EarthquakeRepositoryImpl(api)
    }
}