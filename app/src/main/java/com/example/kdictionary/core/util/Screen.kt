package com.example.kdictionary.core.util

sealed class Screen(val route: String) {
    object DictionaryScreen : Screen("dictionary_screen")
    object SomeOtherScreen : Screen("other_screen")
}
