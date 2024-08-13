package com.example.composeApp.domain.usecases

import com.example.composeApp.domain.model.Product
import com.example.composeApp.domain.repository.AppRepository
import io.ktor.client.statement.*

class GetExampleDataUseCase(private val repository: AppRepository) {
    suspend operator fun invoke(): Result<List<Product>> {
        return repository.getExampleData()
    }
}
