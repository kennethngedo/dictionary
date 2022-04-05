package com.example.kdictionary.dictionary.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Meaning(
    val definitions: List<Definition>,
    val partOfSpeech: String
)