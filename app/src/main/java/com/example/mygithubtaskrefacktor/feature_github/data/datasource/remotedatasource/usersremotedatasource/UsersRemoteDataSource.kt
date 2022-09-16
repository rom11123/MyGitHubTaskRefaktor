package com.example.mygithubtaskrefacktor.feature_github.data.datasource.remotedatasource.usersremotedatasource

import com.example.mygithubtaskrefacktor.feature_github.data.entity.response.AllUsersResponse
import retrofit2.Response

interface UsersRemoteDataSource {
    suspend fun getAllUsers():Response<List<AllUsersResponse>>
}