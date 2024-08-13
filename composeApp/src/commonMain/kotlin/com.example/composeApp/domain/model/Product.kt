package com.example.composeApp.domain.model

data class Product(
    val name: String,
    val images: List<String>,
    val reviews: List<Review>,
    val price: Double
)
data class Review(
    val rate: Double,
    val date: String
)