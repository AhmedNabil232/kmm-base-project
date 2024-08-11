package com.example.composeApp.data.repository

import com.example.composeApp.domain.repository.AppRepository
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class AppRepositoryImpl(private val client: HttpClient): AppRepository {
    override suspend fun getExampleData() {
        val response: HttpResponse = client.get("https://api.example.com/data")

    }
}