package com.example.brijeshproject.model

data class Order(
    val id: String,
    val sareeId: String,
    val customerName: String,
    val status: OrderStatus,
    val orderDate: Long,
    val estimatedDelivery: Long
)

enum class OrderStatus {
    PLACED,
    WEAVING,
    SHIPPED,
    DELIVERED
}
