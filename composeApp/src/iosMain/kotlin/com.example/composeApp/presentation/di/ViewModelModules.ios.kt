package com.example.composeApp.presentation.di
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.example.composeApp.presentation.app.AppViewModel

actual val viewModelsModule =  module {
    singleOf(::AppViewModel)
}