package com.example.composeApp.presentation.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeApp.domain.usecases.GetExampleDataUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AppViewModel(private val getExampleDataUseCase: GetExampleDataUseCase) : ViewModel() {

    private val _data = MutableStateFlow<String?>(null)
    private val error = MutableStateFlow<String?>(null)
    val data: StateFlow<String?> get() = _data

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            getExampleDataUseCase.invoke()
            _data.value = ""
        }
    }
}
