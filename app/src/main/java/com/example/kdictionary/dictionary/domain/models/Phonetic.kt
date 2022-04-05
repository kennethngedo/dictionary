package com.example.kdictionary.dictionary.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Phonetic(
    val audio: String,
    val text: String
)