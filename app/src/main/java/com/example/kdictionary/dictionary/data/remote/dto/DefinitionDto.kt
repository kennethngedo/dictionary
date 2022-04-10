package com.example.kdictionary.dictionary.data.remote.dto

import com.example.kdictionary.dictionary.domain.models.Definition



data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val example: String,
    val synonyms: List<String>
) {
    fun toDefinition() = Definition(
        antonyms = antonyms,
        definition = definition,
        synonyms = synonyms
    )
}