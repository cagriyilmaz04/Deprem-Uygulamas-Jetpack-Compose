package com.example.depremapp.data.model

data class Airport(
    val distance: Double,
    val name: String,
    val code: String,
    val coordinates: GeoJson
)