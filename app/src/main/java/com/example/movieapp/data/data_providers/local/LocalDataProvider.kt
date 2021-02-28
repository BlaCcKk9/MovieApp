package com.example.movieapp.data.data_providers.local

interface LocalDataProvider {
    fun getToken(): String

    fun setToken(token: String)

    fun setStage(stage: Boolean)

    fun isStage(): Boolean
}