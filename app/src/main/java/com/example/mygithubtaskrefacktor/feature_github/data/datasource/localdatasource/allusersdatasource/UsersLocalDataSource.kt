package com.example.mygithubtaskrefacktor.feature_github.data.datasource.localdatasource.allusersdatasource

import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.AllUsersEntity
import kotlinx.coroutines.flow.Flow

interface UsersLocalDataSource {

    suspend fun getAllUsers():List<AllUsersEntity>
    suspend fun insert(users:List<AllUsersEntity>)
    suspend fun deleteAll()
}