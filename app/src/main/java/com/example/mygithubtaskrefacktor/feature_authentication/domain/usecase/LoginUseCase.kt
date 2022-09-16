package com.example.mygithubtaskrefacktor.feature_authentication.domain.usecase

import com.example.mygithubtaskrefacktor.core.model.Resource
import com.example.mygithubtaskrefacktor.feature_authentication.data.entity.projectentity.GithubUserEntity
import kotlinx.coroutines.flow.Flow

interface LoginUseCase {
    fun logIn(): Flow<Resource<GithubUserEntity>>
    fun isLoggedIn(): Boolean
    fun saveEmail(email: String)
    fun saveToken(token: String)
    fun getEmail(): String
    fun getPassword(): String
    fun clear()
}