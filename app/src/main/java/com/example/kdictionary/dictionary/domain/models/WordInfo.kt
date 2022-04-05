package com.example.kdictionary.dictionary.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class WordInfo (
    val meanings: List<Meaning>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<Phonetic>,
    val word: String
)