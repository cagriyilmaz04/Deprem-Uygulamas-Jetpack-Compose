package com.example.depremapp.data.model

data class LocationProperties(
    val closestCity: City,
    val epiCenter: City,
    val closestCities: List<City>,
    val airports: List<Airport>
)
