package com.example.mygithubtaskrefacktor.feature_github.data.datasource.remotedatasource.reporemotedatasource

import com.example.mygithubtaskrefacktor.feature_github.data.entity.response.RepositoryResponse
import retrofit2.Response

interface RepoRemoteDataSource {
    suspend fun getRepositories(): Response<List<RepositoryResponse>>
}