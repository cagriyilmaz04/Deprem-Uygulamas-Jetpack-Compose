package com.example.depremapp.domain.usecase


import com.example.depremapp.domain.repository.EarthquakeRepository
import javax.inject.Inject

class GetEarthquakesUseCase @Inject constructor(
    private val repository: EarthquakeRepository
) {
    suspend operator fun invoke() = repository.getEarthquakes()
}