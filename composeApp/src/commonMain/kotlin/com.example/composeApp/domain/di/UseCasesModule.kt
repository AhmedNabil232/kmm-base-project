package com.example.composeApp.domain.di

import com.example.composeApp.data.network.HttpClientFactory
import com.example.composeApp.domain.usecases.GetExampleDataUseCase
import org.koin.dsl.module


val usecaseModule = module {
    single { GetExampleDataUseCase(repository = get()) }
}
