package com.example.composeApp.domain.repository

import com.example.composeApp.domain.model.Product

interface AppRepository {
    suspend fun getExampleData():Result<List<Product>>
}