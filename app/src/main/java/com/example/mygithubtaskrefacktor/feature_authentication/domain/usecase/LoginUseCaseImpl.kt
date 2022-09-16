package com.example.mygithubtaskrefacktor.feature_authentication.domain.usecase

import com.example.mygithubtaskrefacktor.core.model.Resource
import com.example.mygithubtaskrefacktor.feature_authentication.data.entity.projectentity.GithubUserEntity
import com.example.mygithubtaskrefacktor.feature_authentication.data.repository.LoginRepository
import kotlinx.coroutines.flow.Flow

class LoginUseCaseImpl(private val repository:LoginRepository):LoginUseCase {
    override fun logIn(): Flow<Resource<GithubUserEntity>> = repository.logIn()

    override fun isLoggedIn() =
        repository.getPassword().isNotEmpty() &&
                repository.getEmail().isNotEmpty()

    override fun saveEmail(email: String) =
        repository.setEmail(email)

    override fun saveToken(token: String) = repository.setToken(token)

    override fun getEmail(): String = repository.getEmail()

    override fun getPassword(): String = repository.getPassword()

    override fun clear() = repository.clear()
}