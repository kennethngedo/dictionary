package com.example.kdictionary.dictionary.data.remote.dto

import com.example.kdictionary.dictionary.domain.models.Phonetic

data class PhoneticDto(
    val audio: String,
    val text: String
) {
    fun toPhonetic() = Phonetic(
        audio = audio,
        text = text
    )
}