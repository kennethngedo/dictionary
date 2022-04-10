package com.example.kdictionary.commons.utils

sealed class Screen(val route: String) {
    object DictionaryScreen : Screen("dictionary_screen")
    object SomeOtherScreen : Screen("other_screen")
}
