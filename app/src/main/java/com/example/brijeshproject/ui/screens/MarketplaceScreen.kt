package com.example.brijeshproject.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.brijeshproject.data.AppRepository
import com.example.brijeshproject.model.Saree

import androidx.compose.ui.res.stringResource
import com.example.brijeshproject.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarketplaceScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(stringResource(R.string.marketplace)) }) },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { navController.navigate("custom_order") },
                icon = { Icon(Icons.Default.Edit, contentDescription = null) },
                text = { Text("Custom Order") },
            )
        }
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(padding).fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(AppRepository.sarees) { saree ->
                SareeCard(saree)
            }
        }
    }
}

@Composable
fun SareeCard(saree: Saree) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.padding(8.dp)) {
            // Coil image loading would go here: AsyncImage(model = saree.imageUrl, ...)
            Text(saree.name, style = MaterialTheme.typography.titleMedium, maxLines = 1)
            Text("₹${saree.price}", style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.secondary)
            Text(saree.type.name, style = MaterialTheme.typography.labelSmall)
            Button(onClick = { /* Add to cart */ }, modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
                Text(stringResource(R.string.buy_now))
            }
        }
    }
}
