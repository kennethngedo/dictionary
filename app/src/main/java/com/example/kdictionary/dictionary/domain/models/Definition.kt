package com.example.kdictionary.dictionary.domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Definition(
    val antonyms: List<String>,
    val definition: String,
    val example: String,
    val synonyms: List<String>
)