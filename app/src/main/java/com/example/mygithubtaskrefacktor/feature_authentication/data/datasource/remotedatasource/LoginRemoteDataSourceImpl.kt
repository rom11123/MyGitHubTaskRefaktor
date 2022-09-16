package com.example.mygithubtaskrefacktor.feature_authentication.data.datasource.remotedatasource

import com.example.mygithubtaskrefacktor.core.restservice.GithubApiService
import com.example.mygithubtaskrefacktor.feature_authentication.data.entity.response.GithubUserResponse
import retrofit2.Response


class LoginRemoteDataSourceImpl(private val api: GithubApiService) : LoginRemoteDataSource {
    override suspend fun getUser(): Response<GithubUserResponse>  = api.getUser()

}