package com.example.depremapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.depremapp.domain.model.Earthquake
import com.example.depremapp.presentation.viewmodel.EarthquakeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: EarthquakeViewModel) {
    val earthquakes by viewModel.earthquakeList.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchEarthquakes()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Deprem Listesi") })
        }
    ) { paddingValues ->
        EarthquakeList(earthquakes, Modifier.padding(paddingValues))
    }
}

@Composable
fun EarthquakeList(earthquakes: List<Earthquake>, modifier: Modifier) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(earthquakes) { earthquake ->
            EarthquakeItem(earthquake)
        }
    }
}

@Composable
fun EarthquakeItem(earthquake: Earthquake) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = earthquake.title, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Tarih: ${earthquake.date}")
            Text(text = "Büyüklük: ${earthquake.magnitude}")
            Text(text = "Derinlik: ${earthquake.depth} km")
        }
    }
}
