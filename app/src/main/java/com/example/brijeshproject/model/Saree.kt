package com.example.brijeshproject.model

data class Saree(
    val id: String,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrl: String,
    val weaverId: String,
    val type: SareeType, // Ilkal, Molakalmuru
    val colors: List<String>,
    val material: String,
    val rating: Float,
    val reviewsCount: Int
)

enum class SareeType {
    ILKAL,
    MOLAKALMURU
}
