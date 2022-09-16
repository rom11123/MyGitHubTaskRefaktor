package com.example.mygithubtaskrefacktor.feature_github.data.datasource.localdatasource.repositorydatasource

import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.RepositoryEntity
import com.example.mygithubtaskrefacktor.feature_github.data.room.repodatabase.RepositoriesDao
import kotlinx.coroutines.flow.Flow

class RepositoriesLocalDataSourceImpl(private val repositoriesDao: RepositoriesDao):RepositoriesLocalDataSource {
    override suspend fun getRepositories(): Flow< List<RepositoryEntity>>  =
        repositoriesDao.readAllData()


    override suspend fun insert(repositories: List<RepositoryEntity>)  =
         repositoriesDao.insert(repositories)


    override suspend fun delete()  = repositoriesDao.deleteAll()

}