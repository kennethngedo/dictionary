package com.example.kdictionary.dictionary.presentation

import com.example.kdictionary.dictionary.domain.models.WordInfo

data class WordInfoState (
    val wordInfoItems: List<WordInfo> = emptyList(),
    val isLoading: Boolean = false
)