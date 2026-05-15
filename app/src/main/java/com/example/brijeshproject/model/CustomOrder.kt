package com.example.brijeshproject.model

data class CustomOrder(
    val id: String = "",
    val customerName: String,
    val weaverId: String,
    val sareeType: SareeType,
    val preferredColors: String,
    val designInstructions: String,
    val status: String = "Requested",
    val requestDate: Long = System.currentTimeMillis()
)
