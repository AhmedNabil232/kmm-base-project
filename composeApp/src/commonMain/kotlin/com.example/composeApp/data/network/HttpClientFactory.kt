package com.example.composeApp.data.network

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

//class HttpClientFactory {
//    fun create(): HttpClient {
//        return HttpClient(engineFactory()) {
//            install(ContentNegotiation) {
//                json(Json {
//                    prettyPrint = true
//                    isLenient = true
//                })
//            }
//        }
//    }
//
//    private fun engineFactory(): HttpClientEngineFactory<HttpClientEngineConfig> =
//        if (Platform.isAndroid) OS.Android else Darwin
//}