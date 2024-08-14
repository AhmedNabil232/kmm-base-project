package com.example.composeApp.presentation.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeApp.presentation.common.AppBar
import com.example.composeApp.presentation.utils.koinViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.compose.getKoin
import org.koin.core.qualifier.named


@Composable
@Preview
fun App(
    navController: NavHostController = rememberNavController()
) {
    KoinContext {
        MaterialTheme {
            Scaffold(topBar = {
                AppBar(title = "Products", canNavigateBack = false, navigateUp = {})
            }) { innerPadding ->
                val appScope = getKoin().createScope("appScope", named("app"))
                val viewModel = koinViewModel<AppViewModel>()
                NavHost(
                    navController = navController,
                    startDestination = ProductList,
                    modifier = Modifier.fillMaxSize().padding(innerPadding)
                ) {
                    composable<ProductList> {
                        ProductsListScreen(navController)
                    }
                    composable<ProductDetails> {
                        ProductDetailsScreen()
                    }
                }

            }

        }
    }
}
