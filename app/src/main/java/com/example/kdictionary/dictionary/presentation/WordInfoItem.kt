package com.example.kdictionary.dictionary.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kdictionary.R
import com.example.kdictionary.dictionary.domain.models.WordInfo

@Composable
fun WordInfoItem(word: WordInfo) {
    val listState = rememberLazyListState()
    val italicsStyle = TextStyle(
        fontStyle = FontStyle.Italic
    )
    Box(modifier = Modifier.fillMaxWidth()) {
        // Word
        Text(
            text = "hello".lowercase(), style = TextStyle(
                color = Color.Magenta,
                fontSize = 20.sp
            )
        )
        // Phonetics
        Text(
            text = "/həˈləʊ/".lowercase(), style = TextStyle(
                color = Color.Gray,
            )
        )
        Spacer(modifier = Modifier.height(5.dp))
        // Origin
        Text(
            text = stringResource(id = R.string.origin).lowercase(),
            style = italicsStyle
        )
        Text(
            text = "origin text".lowercase(), style = TextStyle(
                color = Color.Gray,
            ),
            modifier = Modifier.fillMaxWidth()
        )
        // Meanings
        Text(
            text = stringResource(id = R.string.meanings).lowercase(),
            style = italicsStyle
        )
        LazyColumn(state = listState) {

        }
    }
}