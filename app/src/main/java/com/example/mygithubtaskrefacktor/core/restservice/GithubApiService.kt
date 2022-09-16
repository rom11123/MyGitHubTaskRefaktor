package com.example.mygithubtaskrefacktor.core.restservice

import com.example.mygithubtaskrefacktor.feature_authentication.data.entity.response.GithubUserResponse
import com.example.mygithubtaskrefacktor.feature_github.data.entity.response.AllUsersResponse
import com.example.mygithubtaskrefacktor.feature_github.data.entity.response.RepositoryResponse
import retrofit2.Response
import retrofit2.http.GET


interface GithubApiService {

    @GET(USER_ENDPOINT)
    suspend fun getUser():Response<GithubUserResponse>

    @GET(USERS_ENDPOINT)
    suspend fun getAllUsers():Response<List<AllUsersResponse>>

    @GET(USER_REPOSITORIES)
    suspend fun getRepositories():Response<List<RepositoryResponse>>

}