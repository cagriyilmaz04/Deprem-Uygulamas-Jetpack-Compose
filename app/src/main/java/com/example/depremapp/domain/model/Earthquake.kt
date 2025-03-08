package com.example.depremapp.domain.model

import com.example.depremapp.data.model.EarthquakeData

data class Earthquake(
    val id: String,
    val title: String,
    val date: String,
    val magnitude: Double,
    val depth: Double
)
fun EarthquakeData.toDomain(): Earthquake {
    return Earthquake(
        id = this.id,
        title = this.title,
        date = this.date,
        magnitude = this.mag,
        depth = this.depth
    )
}