package com.example.kdictionary.dictionary.data.remote.dto

import com.example.kdictionary.dictionary.domain.models.WordInfo

data class WordDto(
    val meanings: List<MeaningDto>,
    val origin: String,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val word: String
) {
    fun toWord() = WordInfo(
        meanings = meanings.map { it.toMeaning() },
        origin = origin,
        phonetic = phonetic,
        phonetics = phonetics.map { it.toPhonetic() },
        word = word
    )
}