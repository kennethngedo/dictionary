package com.example.kdictionary.commons.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kdictionary.core.util.Screen
import com.example.kdictionary.dictionary.presentation.DictionaryScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.DictionaryScreen.route) {
        composable(route = Screen.DictionaryScreen.route) {
            DictionaryScreen(navController = navController)
        }
    }
}