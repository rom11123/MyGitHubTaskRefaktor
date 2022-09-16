package com.example.mygithubtaskrefacktor.feature_authentication.data.repository

import com.example.mygithubtaskrefacktor.core.model.Resource
import com.example.mygithubtaskrefacktor.feature_authentication.data.entity.projectentity.GithubUserEntity
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun setEmail(email: String)
    fun setToken(token: String)
    fun getEmail(): String
    fun getPassword(): String
    fun clear()
    fun logIn(): Flow<Resource<GithubUserEntity>>

}