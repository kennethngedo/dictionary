package com.example.kdictionary.commons.utils

sealed class UIEvent {
    data class ShowSnackbar(val message: String): UIEvent()
}
