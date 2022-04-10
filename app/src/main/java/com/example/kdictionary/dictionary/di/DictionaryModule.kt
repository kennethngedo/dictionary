package com.example.kdictionary.dictionary.di

import com.example.kdictionary.dictionary.data.remote.DictionaryApi
import com.example.kdictionary.dictionary.data.repository.DictionaryRepositoryImpl
import com.example.kdictionary.dictionary.domain.repository.DictionaryRepository
import com.example.kdictionary.dictionary.domain.usescases.GetWordInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DictionaryModule {

    @Provides
    fun providesDictionaryApi() : DictionaryApi {
        val builder = Retrofit.Builder()
            .baseUrl(DictionaryApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return builder.create(DictionaryApi::class.java)
    }

    @Provides
    fun providesDictionaryRepository(api: DictionaryApi) : DictionaryRepository {
        return DictionaryRepositoryImpl(api)
    }

    @Provides
    fun providesGetWordInfoUseCase(repository: DictionaryRepository): GetWordInfo {
        return GetWordInfo(repository)
    }


}