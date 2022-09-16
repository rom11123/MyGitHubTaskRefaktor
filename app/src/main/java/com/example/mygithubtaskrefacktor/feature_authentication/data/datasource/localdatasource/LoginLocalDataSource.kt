package com.example.mygithubtaskrefacktor.feature_authentication.data.datasource.localdatasource

interface LoginLocalDataSource {
    fun getEmail(): String
    fun getPassword(): String
    fun setEmail(email: String)
    fun setToken(token: String)
    fun clear()
}