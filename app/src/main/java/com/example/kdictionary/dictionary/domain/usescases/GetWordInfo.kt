package com.example.kdictionary.dictionary.domain.usescases

import com.example.kdictionary.commons.utils.Resource
import com.example.kdictionary.dictionary.domain.models.WordInfo
import com.example.kdictionary.dictionary.domain.repository.DictionaryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetWordInfo(
    private val repository: DictionaryRepository
) {
    operator fun invoke(word: String) : Flow<Resource<List<WordInfo>>> {
        if (word.isBlank()) {
            return flow {  }
        }
        return repository.getWordInfo(word)
    }
}