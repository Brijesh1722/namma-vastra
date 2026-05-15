package com.example.brijeshproject.model

data class Trend(
    val id: String,
    val title: String,
    val description: String,
    val recommendedColors: List<String>,
    val imageUrl: String,
    val season: String
)
