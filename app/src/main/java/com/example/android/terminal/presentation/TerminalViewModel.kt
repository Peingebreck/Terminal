package com.example.android.terminal.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.terminal.data.ApiFactory
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TerminalViewModel : ViewModel() {

    private val apiService = ApiFactory.apiService

    private val _state = MutableStateFlow<TerminalScreenState>(TerminalScreenState.Initial)
    val state
        get() = _state.asStateFlow()

    private var lastState: TerminalScreenState = TerminalScreenState.Initial

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _state.value = lastState
        Log.d("TerminalViewModel", "Exception caught: $throwable")
    }

    init {
        loadBarList()
    }

    fun loadBarList(timeFrame: TimeFrame = TimeFrame.HOUR_1) {
        lastState = _state.value
        _state.value = TerminalScreenState.Loading
        viewModelScope.launch(exceptionHandler) {
            val barList = apiService.loadBars(timeFrame.value).barList
            _state.value = TerminalScreenState.Content(barList = barList, timeFrame = timeFrame)
        }
    }
}