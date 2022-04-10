package com.example.kdictionary.dictionary.domain.models


data class Definition(
    val antonyms: List<String>,
    val definition: String,
    val synonyms: List<String>
)