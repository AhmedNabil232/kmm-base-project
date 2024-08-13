package com.example.composeApp.presentation.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeApp.domain.model.Product
import com.example.composeApp.domain.usecases.GetExampleDataUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AppViewModel(private val getExampleDataUseCase: GetExampleDataUseCase) : ViewModel() {

    private val _data = MutableStateFlow<List<Product>?>(null)
    val data: StateFlow<List<Product>?> get() = _data
    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            getExampleDataUseCase.invoke().onSuccess {
                _data.value = it
            }.onFailure {
                _error.value = it.message
            }
        }
    }
}
