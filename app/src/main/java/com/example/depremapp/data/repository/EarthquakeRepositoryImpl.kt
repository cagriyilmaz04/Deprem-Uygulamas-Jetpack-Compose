package com.example.depremapp.data.repository

import com.example.depremapp.data.api.EarthquakeApi
import com.example.depremapp.domain.model.Earthquake
import com.example.depremapp.domain.model.toDomain
import com.example.depremapp.domain.repository.EarthquakeRepository
import javax.inject.Inject

class EarthquakeRepositoryImpl @Inject constructor(
    private val api: EarthquakeApi
) : EarthquakeRepository {
    override suspend fun getEarthquakes(): List<Earthquake> {
        val response = api.getEarthquakes()
        return if (response.isSuccessful) {
            response.body()?.result?.map { it.toDomain() } ?: emptyList()
        } else {
            emptyList()
        }
    }
}