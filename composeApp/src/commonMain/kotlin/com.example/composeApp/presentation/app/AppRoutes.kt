package com.example.composeApp.presentation.app

import com.example.composeApp.domain.model.Product
import kotlinx.serialization.Serializable

@Serializable
object ProductList
@Serializable
data class ProductDetails(val productId: String? = null)


