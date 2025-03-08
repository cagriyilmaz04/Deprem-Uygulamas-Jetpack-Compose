package com.example.depremapp.domain.repository

import com.example.depremapp.domain.model.Earthquake

interface EarthquakeRepository {
    suspend fun getEarthquakes(): List<Earthquake>
}