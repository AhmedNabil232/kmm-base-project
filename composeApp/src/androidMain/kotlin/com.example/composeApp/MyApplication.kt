package com.example.composeApp
import android.app.Application
import com.example.composeApp.data.di.networkModule
import com.example.composeApp.domain.di.usecaseModule
import com.example.composeApp.presentation.di.KoinInitializer
import com.example.composeApp.presentation.di.viewModelsModule
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KoinInitializer(this).init()
    }
}