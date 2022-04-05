package com.example.kdictionary

import android.app.Application
import com.example.kdictionary.dictionary.di.DictionaryModule
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        DictionaryModule

    }
}