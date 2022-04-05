package com.example.kdictionary.dictionary.data.remote.dto

import com.example.kdictionary.dictionary.domain.models.Meaning
import kotlinx.serialization.SerialName

data class MeaningDto(
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String
) {
    fun toMeaning() = Meaning(
        definitions = definitions.map { it.toDefinition() },
        partOfSpeech = partOfSpeech
    )
}