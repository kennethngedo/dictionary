package com.example.kdictionary.dictionary.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kdictionary.commons.theme.KDictionaryTheme
import com.example.kdictionary.commons.utils.UIEvent
import com.example.kdictionary.dictionary.domain.models.Definition
import com.example.kdictionary.dictionary.domain.models.Meaning
import com.example.kdictionary.dictionary.domain.models.WordInfo
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DictionaryScreen(
    state: WordInfoState,
    searchQuery: String,
    eventFlow: SharedFlow<UIEvent>,
    onSearch: (query: String) -> Unit
) {
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        eventFlow.collectLatest { event ->
            when(event) {
                is UIEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message
                    )
                }
            }
        }
    }

    Scaffold(scaffoldState = scaffoldState) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = searchQuery,
                placeholder = { Text(stringResource(com.example.kdictionary.R.string.search)) },
                trailingIcon = {
                    if(state.isLoading) {
                        CircularProgressIndicator(
                            color = Color.Cyan,
                            strokeWidth = 3.dp,
                            modifier = Modifier
                                .align(CenterHorizontally)
                                .size(28.dp)
                        )
                    } else Spacer(modifier = Modifier.size(2.dp))
                },
                onValueChange = {
                    onSearch(it)
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.wordInfoItems.size){ i ->
                    val wordInfo = state.wordInfoItems[i]
                    if (i > 0) {
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                    WordInfoItem(wordInfo)
                    if(i < state.wordInfoItems.size - 1) {
                        Divider()
                    }
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
            val state = remember {
                mutableStateOf(
                    WordInfoState(
                        wordInfoItems = listOf(
                            WordInfo(
                                word = "hello",
                                origin = "From somewhere in Zambisa forest",
                                phonetic = "/he'leu/",
                                phonetics = listOf(),
                                meanings = listOf(
                                    Meaning(
                                        partOfSpeech = "verb",
                                        definitions = listOf(
                                            Definition(
                                                definition = "A way to greet another person",
                                                antonyms = listOf(),
                                                synonyms = listOf("Hi", "Yo")
                                            )
                                        )
                                    )
                                )
                            )
                        ),
                        isLoading = false
                    )
                )
            }
            val searchQuery = remember {
                mutableStateOf("Hello")
            }
            DictionaryScreen(
                state = state.value,
                searchQuery = searchQuery.value,
                eventFlow = MutableSharedFlow()
            ) {

            }
        }

    }
}