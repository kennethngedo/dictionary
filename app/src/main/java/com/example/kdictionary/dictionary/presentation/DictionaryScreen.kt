package com.example.kdictionary.dictionary.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.kdictionary.commons.theme.KDictionaryTheme
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DictionaryScreen(navController: NavController) {
    val viewModel: DictionaryViewModel = hiltViewModel()
    val state = viewModel.state.value
    val searchText = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = searchText.value,
            label = { Text(stringResource(com.example.kdictionary.R.string.search)) },
            onValueChange = {
                searchText.value = it
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.wordInfoItems.size){ i ->
                val wordInfo = state.wordInfoItems[i]
                if (i > 0) {
                    Spacer(modifier = Modifier.height(10.dp))
                }
                WordInfoItem(word = wordInfo)
                if(i < state.wordInfoItems.size - 1) {
                    Divider()
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KDictionaryTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val navController = rememberNavController()
            DictionaryScreen(navController = navController)
        }

    }
}