package com.example.composeApp

import androidx.compose.ui.window.ComposeUIViewController
import com.example.composeApp.presentation.app.App
import com.example.composeApp.presentation.di.KoinInitializer

fun MainViewController() = ComposeUIViewController(
    configure = {
        KoinInitializer().init()
    }
) {
    App()
}