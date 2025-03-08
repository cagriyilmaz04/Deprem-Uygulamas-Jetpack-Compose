package com.example.depremapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.depremapp.presentation.screens.HomeScreen
import com.example.depremapp.presentation.viewmodel.EarthquakeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel: EarthquakeViewModel = hiltViewModel()
            HomeScreen(viewModel)
        }
    }
}
