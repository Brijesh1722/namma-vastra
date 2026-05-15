package com.example.brijeshproject.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.brijeshproject.data.AppRepository
import com.example.brijeshproject.model.SareeType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomOrderScreen(navController: NavController, weaverId: String? = null) {
    var customerName by remember { mutableStateOf("") }
    var selectedType by remember { mutableStateOf(SareeType.ILKAL) }
    var colors by remember { mutableStateOf("") }
    var instructions by remember { mutableStateOf("") }
    var selectedWeaverId by remember { mutableStateOf(weaverId ?: AppRepository.weavers.first().id) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Request Custom Saree") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            Text("Tell us about your dream saree", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = customerName,
                onValueChange = { customerName = it },
                label = { Text("Your Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text("Select Saree Type", style = MaterialTheme.typography.titleMedium)
            Row {
                SareeType.entries.forEach { type ->
                    Row(modifier = Modifier.padding(end = 8.dp)) {
                        RadioButton(
                            selected = selectedType == type,
                            onClick = { selectedType = type }
                        )
                        Text(type.name, modifier = Modifier.padding(top = 12.dp))
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text("Select Weaver", style = MaterialTheme.typography.titleMedium)
            AppRepository.weavers.forEach { weaver ->
                Row {
                    RadioButton(
                        selected = selectedWeaverId == weaver.id,
                        onClick = { selectedWeaverId = weaver.id },
                    )
                    Text("${weaver.name} (${weaver.location})", modifier = Modifier.padding(top = 12.dp))
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = colors,
                onValueChange = { colors = it },
                label = { Text("Preferred Colors") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = instructions,
                onValueChange = { instructions = it },
                label = { Text("Design Instructions") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    // Logic to save order would go here
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth(),
                enabled = customerName.isNotBlank() && colors.isNotBlank()
            ) {
                Text("Submit Custom Request")
            }
        }
    }
}
