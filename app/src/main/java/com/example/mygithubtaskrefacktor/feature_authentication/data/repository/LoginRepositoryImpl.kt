package com.example.mygithubtaskrefacktor.feature_authentication.data.repository

import com.example.mygithubtaskrefacktor.core.model.Resource
import com.example.mygithubtaskrefacktor.core.repository.safeApiCall
import com.example.mygithubtaskrefacktor.core.repository.safeApiCallFlow
import com.example.mygithubtaskrefacktor.feature_authentication.data.datasource.localdatasource.LoginLocalDataSource
import com.example.mygithubtaskrefacktor.feature_authentication.data.datasource.remotedatasource.LoginRemoteDataSource
import com.example.mygithubtaskrefacktor.feature_authentication.data.entity.projectentity.GithubUserEntity
import com.example.mygithubtaskrefacktor.feature_authentication.mapper.RESPONSE_TO_GITHUB_USER
import kotlinx.coroutines.flow.Flow

class LoginRepositoryImpl(
    private val loginLocalDataSource: LoginLocalDataSource,
    private val loginRemoteDataSource: LoginRemoteDataSource,
) : LoginRepository {
    override fun setEmail(email: String) = loginLocalDataSource.setEmail(email)


    override fun setToken(token: String) = loginLocalDataSource.setToken(token)


    override fun getEmail(): String = loginLocalDataSource.getEmail()


    override fun getPassword(): String = loginLocalDataSource.getPassword()


    override fun clear() = loginLocalDataSource.clear()


    override fun logIn(): Flow<Resource<GithubUserEntity>> =
        safeApiCallFlow(
            { loginRemoteDataSource.getUser() },
           RESPONSE_TO_GITHUB_USER::map
        )

}