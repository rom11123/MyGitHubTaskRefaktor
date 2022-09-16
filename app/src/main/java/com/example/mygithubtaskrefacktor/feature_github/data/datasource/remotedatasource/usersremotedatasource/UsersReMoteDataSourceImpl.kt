package com.example.mygithubtaskrefacktor.feature_github.data.datasource.remotedatasource.usersremotedatasource

import com.example.mygithubtaskrefacktor.core.restservice.GithubApiService
import com.example.mygithubtaskrefacktor.feature_github.data.entity.response.AllUsersResponse
import retrofit2.Response

class UsersReMoteDataSourceImpl(private val api:GithubApiService):UsersRemoteDataSource {
    override suspend fun getAllUsers(): Response<List<AllUsersResponse>>  =
        api.getAllUsers()

}