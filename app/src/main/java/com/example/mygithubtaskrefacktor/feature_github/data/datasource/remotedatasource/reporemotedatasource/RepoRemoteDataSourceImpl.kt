package com.example.mygithubtaskrefacktor.feature_github.data.datasource.remotedatasource.reporemotedatasource

import com.example.mygithubtaskrefacktor.core.restservice.GithubApiService
import com.example.mygithubtaskrefacktor.feature_github.data.entity.response.RepositoryResponse
import retrofit2.Response

class RepoRemoteDataSourceImpl(private val api:GithubApiService):RepoRemoteDataSource {
    override suspend fun getRepositories(): Response<List<RepositoryResponse>>  =
         api.getRepositories()
}