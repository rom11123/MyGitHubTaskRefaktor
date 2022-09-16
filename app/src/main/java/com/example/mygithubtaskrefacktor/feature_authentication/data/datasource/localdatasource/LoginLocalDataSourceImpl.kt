package com.example.mygithubtaskrefacktor.feature_authentication.data.datasource.localdatasource

import android.content.SharedPreferences
import com.example.mygithubtaskrefacktor.feature_authentication.data.EMAIL
import com.example.mygithubtaskrefacktor.feature_authentication.data.PASSWORD

class LoginLocalDataSourceImpl(private val sharedPreferences: SharedPreferences) : LoginLocalDataSource {

    override fun getEmail(): String = sharedPreferences.getString(EMAIL, null) ?: ""


    override fun getPassword(): String = sharedPreferences.getString(PASSWORD, null) ?: ""


    override fun setEmail(email: String) = sharedPreferences.edit().putString(EMAIL, email).apply()


    override fun setToken(token: String) =
        sharedPreferences.edit().putString(PASSWORD, token).apply()


    override fun clear() {
        sharedPreferences.edit().clear().apply()
    }
}