package com.example.composeApp.data.network

import com.example.composeApp.domain.utils.Logger

private const val TAG = "HttpClientLogger"

public object HttpClientLogger : io.ktor.client.plugins.logging.Logger {

  override fun log(message: String) {
    Logger.d(TAG, message)
  }
}