package com.example.composeApp.data.repository

import com.example.composeApp.data.model.ProductsResponse
import com.example.composeApp.domain.model.Product
import com.example.composeApp.domain.model.mapToProduct
import com.example.composeApp.domain.repository.AppRepository
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.isSuccess

class AppRepositoryImpl(private val client: HttpClient) : AppRepository {
    override suspend fun getExampleData(): Result<List<Product>> {
        try {
            val response: HttpResponse = client.get("https://dummyjson.com/products")
            if (response.status.isSuccess()) {
                val data: ProductsResponse = response.body()
                return Result.success(data.products!!.map { mapToProduct(it!!) })
            } else {
                return Result.failure(Exception("Error"))
            }
        } catch (t: Throwable) {
            return Result.failure(t)
        }


    }
}