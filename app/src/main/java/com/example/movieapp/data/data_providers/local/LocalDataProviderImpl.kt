package com.example.movieapp.data.data_providers.local

import android.content.SharedPreferences
import javax.inject.Inject

class LocalDataProviderImpl @Inject constructor(
    private val preferences: SharedPreferences
) : LocalDataProvider {

    private val editor: SharedPreferences.Editor = preferences.edit()

    override fun getToken() = preferences.getString(TOKEN, "") ?: ""

    override fun setToken(token: String) {
        editor.putString(TOKEN, token).apply()
    }

    override fun setStage(stage: Boolean) {
        editor.putBoolean(IS_STAGE, stage).commit()
    }

    override fun isStage() = preferences.getBoolean(IS_STAGE, false)

}