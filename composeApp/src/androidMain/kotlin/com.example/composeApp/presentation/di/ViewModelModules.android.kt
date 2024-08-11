package com.example.composeApp.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.example.composeApp.presentation.app.AppViewModel

actual val viewModelsModule = module {
    viewModelOf(::AppViewModel)
}