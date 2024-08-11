package com.example.composeApp.data.di

import com.example.composeApp.data.network.HttpClientFactory
import com.example.composeApp.data.repository.AppRepositoryImpl
import com.example.composeApp.domain.repository.AppRepository
import org.koin.dsl.module

val networkModule = module {
    single { HttpClientFactory().create() }
    single<AppRepository> { AppRepositoryImpl(client = get()) }
}
