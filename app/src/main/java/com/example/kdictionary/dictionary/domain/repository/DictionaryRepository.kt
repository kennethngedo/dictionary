package com.example.kdictionary.dictionary.domain.repository

import com.example.kdictionary.commons.utils.Resource
import com.example.kdictionary.dictionary.domain.models.WordInfo
import kotlinx.coroutines.flow.Flow

interface DictionaryRepository  {
    fun getWordInfo(word: String) : Flow<Resource<List<WordInfo>>>
}