package com.example.kdictionary.commons.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kdictionary.commons.utils.Screen
import com.example.kdictionary.dictionary.presentation.DictionaryScreen
import com.example.kdictionary.dictionary.presentation.DictionaryViewModel

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.DictionaryScreen.route) {

        composable(route = Screen.DictionaryScreen.route) {
            val viewModel: DictionaryViewModel = hiltViewModel()
            DictionaryScreen(
                viewModel.state.value,
                viewModel.searchQuery.value,
                viewModel.eventFlow,
                viewModel::onSearch
            )
        }

    }
}