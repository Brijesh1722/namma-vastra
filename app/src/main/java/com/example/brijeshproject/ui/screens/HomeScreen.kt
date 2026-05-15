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
import com.example.brijeshproject.model.Trend

import androidx.compose.ui.res.stringResource
import com.example.brijeshproject.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) },
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding).fillMaxSize()) {
            item {
                Text("Featured Trends", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(16.dp))
            }
            items(AppRepository.trends) { trend ->
                TrendCard(trend)
            }
            item {
                Text("Popular Weavers", style = MaterialTheme.typography.headlineMedium, modifier = Modifier.padding(16.dp))
            }
            items(AppRepository.weavers) { weaver ->
                Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(weaver.name, style = MaterialTheme.typography.titleLarge)
                        Text(weaver.location, style = MaterialTheme.typography.bodyMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedButton(
                            onClick = { navController.navigate("custom_order?weaverId=${weaver.id}") },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Request Custom Design")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TrendCard(trend: Trend) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(trend.title, style = MaterialTheme.typography.titleLarge)
            Text(trend.description, style = MaterialTheme.typography.bodyMedium)
            Text("Recommended: ${trend.recommendedColors.joinToString(", ")}", color = MaterialTheme.colorScheme.primary)
        }
    }
}
