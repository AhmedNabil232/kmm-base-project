package com.example.composeApp.domain.repository

interface AppRepository {
    suspend fun getExampleData()
}