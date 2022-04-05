package com.example.kdictionary.dictionary.data.repository

import com.example.kdictionary.core.util.Resource
import com.example.kdictionary.dictionary.data.remote.DictionaryApi
import com.example.kdictionary.dictionary.domain.models.WordInfo
import com.example.kdictionary.dictionary.domain.repository.DictionaryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class DictionaryRepositoryImpl(
    private val api : DictionaryApi
) : DictionaryRepository {
    override fun getWordInfo(word: String): Flow<Resource<List<WordInfo>>> = flow {
        try {
            val remoteWordInfo = api.getWordInfo(word)
            emit(Resource.Success(remoteWordInfo.map { it.toWord() }))
        } catch (e: HttpException) {
            emit(Resource.Error(message = "Oops, something went wrong!"))
        } catch (e: IOException) {
            emit(Resource.Error(message = "Couldn't reach server, check your internet connection."))
        }
    }
}