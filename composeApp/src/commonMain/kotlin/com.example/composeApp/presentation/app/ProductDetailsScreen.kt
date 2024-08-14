package com.example.composeApp.presentation.app

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
import coil3.compose.AsyncImage
import com.example.composeApp.domain.model.Product
import com.example.composeApp.presentation.utils.koinViewModel

@Composable
fun ProductDetailsScreen(product: Product? = null) {
    val viewModel = koinViewModel<AppViewModel>()
    val products by viewModel.data.collectAsState()
    val error by viewModel.error.collectAsState()
    println("Ahmed: ${product?.name}")
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

    }
}

