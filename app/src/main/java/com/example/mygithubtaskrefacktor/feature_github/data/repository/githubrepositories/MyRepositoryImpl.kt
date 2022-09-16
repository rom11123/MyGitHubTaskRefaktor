package com.example.mygithubtaskrefacktor.feature_github.data.repository.githubrepositories

import com.example.mygithubtaskrefacktor.core.model.Resourcee
import com.example.mygithubtaskrefacktor.feature_github.data.datasource.localdatasource.repositorydatasource.RepositoriesLocalDataSource
import com.example.mygithubtaskrefacktor.feature_github.data.datasource.remotedatasource.reporemotedatasource.RepoRemoteDataSource
import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.RepositoryEntity
import com.example.mygithubtaskrefacktor.feature_github.data.entity.response.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class MyRepositoryImpl(
    private val remoteDataSource: RepoRemoteDataSource,
    private val localDataSource: RepositoriesLocalDataSource,


    ) : MyRepository {
    override fun getAllUsers(): Flow<Resourcee<List<RepositoryEntity>>> =

        flow {
            try {
                emit(Resourcee.Loading<List<RepositoryEntity>>())

                val response = remoteDataSource.getRepositories().body()?.map { it.toEntity() }


                emit(Resourcee.Success<List<RepositoryEntity>>(response!!))
                localDataSource.getRepositories()
                localDataSource.insert(response)

            } catch (e: HttpException) {
                emit(Resourcee.Error<List<RepositoryEntity>>(e.localizedMessage
                    ?: "An unexpected error occured"))
            } catch (e: IOException) {

                emit(Resourcee.Error<List<RepositoryEntity>>("Couldn't reach server. Check your internet connection."))


            }
        }


}