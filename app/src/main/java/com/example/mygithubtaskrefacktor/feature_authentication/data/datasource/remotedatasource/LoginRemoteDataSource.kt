package com.example.mygithubtaskrefacktor.feature_authentication.data.datasource.remotedatasource

import com.example.mygithubtaskrefacktor.feature_authentication.data.entity.response.GithubUserResponse
import retrofit2.Response

interface LoginRemoteDataSource {
    suspend fun getUser(): Response<GithubUserResponse>
}