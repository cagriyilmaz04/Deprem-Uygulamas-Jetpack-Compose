package com.example.depremapp.data.model

data class EarthquakeResponse(
    val status: Boolean,
    val httpStatus: Int,
    val metadata: Metadata,
    val result: List<EarthquakeData>
)