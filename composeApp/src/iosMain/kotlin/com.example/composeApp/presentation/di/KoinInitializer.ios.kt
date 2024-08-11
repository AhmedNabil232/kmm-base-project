package com.example.composeApp.presentation.di

import com.example.composeApp.data.di.networkModule
import com.example.composeApp.domain.di.usecaseModule
import org.koin.core.context.startKoin

actual class KoinInitializer {
    actual fun init() {
        startKoin {
            modules(networkModule, usecaseModule, viewModelsModule)
        }
    }
}