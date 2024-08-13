package com.example.composeApp.presentation.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.composeApp.domain.model.Product
import com.example.composeApp.presentation.utils.koinViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
fun ProductItem(product: Product) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = product.name, style = MaterialTheme.typography.h6)

        if (product.images.isNotEmpty()) {
            AsyncImage(
                model = product.images.first(),
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }

        Text(
            text = "Price: $${product.price}",
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(top = 8.dp)
        )

        Text(
            text = "Rating: ${product.reviews.firstOrNull()?.rate ?: "N/A"}",
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun ProductList(products: List<Product>) {
    LazyColumn {
        items(products.size) { index ->
            ProductItem(products[index])
        }
    }
}

@Composable
@Preview
fun App() {
    KoinContext {
        MaterialTheme {
            val viewModel = koinViewModel<AppViewModel>()
            val products by viewModel.data.collectAsState()
            val error by viewModel.error.collectAsState()
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                when {
                    error != null -> {
                        // Show error message
                        Text(text = "Error: $error", color = MaterialTheme.colors.error)
                    }

                    products != null -> {
                        // Show list of products
                        ProductList(products ?: emptyList())
                    }

                    else -> {
                        // Show loading indicator
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                    }
                }
            }
        }
    }
}
