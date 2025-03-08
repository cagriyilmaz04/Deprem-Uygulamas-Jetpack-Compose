package com.example.depremapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.depremapp.domain.model.Earthquake
import com.example.depremapp.domain.usecase.GetEarthquakesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class EarthquakeViewModel @Inject constructor(
    private val getEarthquakesUseCase: GetEarthquakesUseCase
) : ViewModel() {

    private val _earthquakeList = MutableStateFlow<List<Earthquake>>(emptyList())
    val earthquakeList = _earthquakeList.asStateFlow()

    fun fetchEarthquakes() {
        viewModelScope.launch {
            _earthquakeList.value = getEarthquakesUseCase()
        }
    }
}