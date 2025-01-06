package com.example.android.terminal.presentation

import com.example.android.terminal.data.Bar

sealed class TerminalScreenState {

    object Initial : TerminalScreenState()

    data class Content(val barList: List<Bar>) : TerminalScreenState()
}