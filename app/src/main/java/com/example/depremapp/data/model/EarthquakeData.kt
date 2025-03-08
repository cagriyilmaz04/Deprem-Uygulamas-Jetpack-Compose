package com.example.depremapp.data.model

import com.google.gson.annotations.SerializedName

data class EarthquakeData(
    @SerializedName("_id") val id: String,
    @SerializedName("earthquake_id") val earthquakeId: String,
    val provider: String,
    val title: String,
    val date: String,
    val mag: Double,
    val depth: Double,
    val geojson: GeoJson,
    @SerializedName("location_properties") val locationProperties: LocationProperties
)
