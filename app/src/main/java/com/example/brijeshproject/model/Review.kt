package com.example.brijeshproject.model

data class Review(
    val id: String,
    val productId: String,
    val userName: String,
    val rating: Int,
    val comment: String,
    val date: Long
)
