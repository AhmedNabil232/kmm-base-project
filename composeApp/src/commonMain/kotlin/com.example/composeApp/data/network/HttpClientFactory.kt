package com.example.composeApp.data.network

import io.ktor.client.*

expect class HttpClientFactory() {
    fun create(): HttpClient
}