package com.example.composeApp.presentation.di

import android.content.Context
import com.example.composeApp.data.di.networkModule
import com.example.composeApp.domain.di.usecaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

actual class KoinInitializer(private val context: Context) {
    actual fun init() {
        startKoin {
            androidContext(context)
            androidLogger()
            modules(networkModule, usecaseModule, viewModelsModule)
        }

    }
}