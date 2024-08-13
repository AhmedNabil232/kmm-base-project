package com.example.composeApp.domain.model

import com.example.composeApp.data.model.ProductsItem

fun mapToProduct(productsItem: ProductsItem): Product {
    return Product(
        name = productsItem.title.orEmpty(),
        images = productsItem.images?.filterNotNull().orEmpty(),
        reviews = productsItem.reviews?.filterNotNull()?.map {
            Review(
                rate = ((it.rating?.toDouble()) ?: 0.0),
                date = it.date.orEmpty()
            )
        }.orEmpty(),
        price = productsItem.price ?: 0.0
    )
}