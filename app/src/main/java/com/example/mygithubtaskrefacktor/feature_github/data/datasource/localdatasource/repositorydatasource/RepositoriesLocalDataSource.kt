package com.example.mygithubtaskrefacktor.feature_github.data.datasource.localdatasource.repositorydatasource

import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.RepositoryEntity
import kotlinx.coroutines.flow.Flow

interface RepositoriesLocalDataSource {

    suspend fun getRepositories(): Flow<List<RepositoryEntity>>
    suspend fun insert(repositories:List<RepositoryEntity>)
    suspend fun delete()
}