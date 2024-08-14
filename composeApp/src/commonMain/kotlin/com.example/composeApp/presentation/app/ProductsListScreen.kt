package com.example.composeApp.presentation.app

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import coil3.compose.AsyncImage
import com.example.composeApp.domain.model.Product
import com.example.composeApp.presentation.utils.koinViewModel

@Composable
fun ProductsListScreen(navController: NavHostController = rememberNavController()){
                val viewModel = koinViewModel<AppViewModel>()
            val products by viewModel.data.collectAsState()
            val error by viewModel.error.collectAsState()
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                when {
                    error != null -> {
                        // Show error message
                        Text(text = "Error: $error", color = MaterialTheme.colorScheme.primary)
                    }

                    products != null -> {
                        // Show list of products
                        ProductList(products ?: emptyList(), navController)
                    }

                    else -> {
                        // Show loading indicator
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                    }
                }
            }
}
@Composable
fun ProductItem(product: Product, navController: NavHostController = rememberNavController()) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                navController.navigate(ProductDetails())
            }
    ) {
        Text(text = product.name, style = MaterialTheme.typography.bodyLarge)

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
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = 8.dp)
        )

        Text(
            text = "Rating: ${product.reviews.firstOrNull()?.rate ?: "N/A"}",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
fun ProductList(products: List<Product>, navController: NavHostController = rememberNavController()) {
    LazyColumn {
        items(products.size) { index ->
            ProductItem(products[index], navController)
        }
    }
}