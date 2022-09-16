package com.example.mygithubtaskrefacktor.feature_github.data.repository.usersrepositories

import com.example.mygithubtaskrefacktor.core.model.Resource
import com.example.mygithubtaskrefacktor.core.repository.safeApiCall
import com.example.mygithubtaskrefacktor.feature_github.data.datasource.localdatasource.allusersdatasource.UsersLocalDataSource
import com.example.mygithubtaskrefacktor.feature_github.data.datasource.remotedatasource.usersremotedatasource.UsersRemoteDataSource
import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.AllUsersEntity
import com.example.mygithubtaskrefacktor.feature_github.data.mapper.RESPONSE_TO_GITHUB_ALL_USERS
import kotlinx.coroutines.flow.Flow

class UsersRepositoriesImpl(
    private val usersRemoteDataSource: UsersRemoteDataSource,
    private val usersLocalDataSource: UsersLocalDataSource,
) : UsersRepositories {
    override fun getAllUsers(): Flow<Resource<List<AllUsersEntity>>> =
        safeApiCall(
            apiCall = { usersRemoteDataSource.getAllUsers() },
            map = RESPONSE_TO_GITHUB_ALL_USERS::map,
            getFromDb = { usersLocalDataSource.getAllUsers() },
            insert = { usersLocalDataSource.insert(it) }
        )

}



