package com.example.kdictionary.dictionary.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kdictionary.R
import com.example.kdictionary.commons.theme.KDictionaryTheme
import com.example.kdictionary.dictionary.domain.models.Definition
import com.example.kdictionary.dictionary.domain.models.Meaning
import com.example.kdictionary.dictionary.domain.models.WordInfo

@Composable
fun WordInfoItem(wordInfo: WordInfo) {
    val listState = rememberLazyListState()
    val italicsStyle = TextStyle(
        fontStyle = FontStyle.Italic,
        fontSize = 16.sp
    )
    Column(modifier = Modifier.fillMaxWidth()) {
        // Word
        Text(
            text = wordInfo.word.lowercase(), style = TextStyle(
                color = Color.Magenta,
                fontSize = 24.sp
            )
        )


        // Origin
        wordInfo.origin?.let {
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = stringResource(id = R.string.origin).lowercase(),
                style = italicsStyle
            )
            Text(
                text = it.lowercase(), style = TextStyle(
                    color = Color.Gray,
                    fontSize = 16.sp
                )
            )

        }



        for ( i in wordInfo.meanings.indices){
            val meaning = wordInfo.meanings[i]
            val phonetic = wordInfo.phonetics[i]
            if(i == 0) {
                Spacer(modifier = Modifier.width(15.dp))
            }
            Text(
                text = "${meaning.partOfSpeech.lowercase()}: ${phonetic.text}",
                style = italicsStyle
            )
            for ( j in meaning.definitions.indices) {
                if (j > 3) break
                if(i == 0) {
                    Spacer(modifier = Modifier.width(15.dp))
                }
                val definition = meaning.definitions[j]
                Text(
                    text = "${definition.definition}: ",
                    style = italicsStyle
                )
                if(i < meaning.definitions.size -1) {
                    Spacer(modifier = Modifier.width(15.dp))
                }
            }
            if(i < wordInfo.meanings.size -1) {
                Spacer(modifier = Modifier.width(15.dp))
            }
        }

        Spacer(modifier = Modifier.width(5.dp))

    }
}

@Preview(showBackground = true)
@Composable
fun WordInfoItemPreview() {
    KDictionaryTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val wordInfo = WordInfo(
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
            WordInfoItem(wordInfo = wordInfo)
        }
    }
}