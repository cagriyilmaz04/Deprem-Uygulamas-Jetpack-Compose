package com.example.depremapp.data.api

import com.example.depremapp.data.model.EarthquakeResponse
import retrofit2.Response
import retrofit2.http.GET

interface EarthquakeApi {

    @GET("deprem/kandilli/live")
    suspend fun getEarthquakes(): Response<EarthquakeResponse>
}