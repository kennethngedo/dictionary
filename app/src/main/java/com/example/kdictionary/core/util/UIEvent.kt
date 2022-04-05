package com.example.kdictionary.core.util

sealed class UIEvent {
    data class ShowSnackbar(val message: String): UIEvent()
    data class ShowToast(val message: String): UIEvent()
}
