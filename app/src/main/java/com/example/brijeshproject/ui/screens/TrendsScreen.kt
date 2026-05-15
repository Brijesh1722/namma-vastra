package com.example.brijeshproject.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.brijeshproject.data.AppRepository

import androidx.compose.ui.res.stringResource
import com.example.brijeshproject.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrendsScreen(navController: NavController) {
    // navController is currently not used but kept for future use (e.g. clicking a trend)
    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(R.string.trends)) }) },
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding).fillMaxSize()) {
            item {
                Text("AI Suggestions for Weavers", style = MaterialTheme.typography.headlineSmall, modifier = Modifier.padding(16.dp))
            }
            items(AppRepository.trends) { trend ->
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(trend.title, style = MaterialTheme.typography.titleLarge)
                        Text(trend.description, style = MaterialTheme.typography.bodyMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(stringResource(R.string.trending_colors), style = MaterialTheme.typography.labelLarge)
                        Row {
                           trend.recommendedColors.forEach { color ->
                               SuggestionChip(onClick = {}, label = { Text(color) }, modifier = Modifier.padding(end = 4.dp))
                           }
                        }
                        Text("Demand Forecast: High", color = MaterialTheme.colorScheme.tertiary, modifier = Modifier.padding(top = 8.dp))
                    }
                }
            }
        }
    }
}
