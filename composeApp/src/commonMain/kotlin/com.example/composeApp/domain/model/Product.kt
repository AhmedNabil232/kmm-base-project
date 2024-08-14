package com.example.composeApp.domain.model

import androidx.core.bundle.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val name: String,
    val images: List<String>,
    val reviews: List<Review>,
    val price: Double
)

@Serializable
data class Review(
    val rate: Double,
    val date: String
)
