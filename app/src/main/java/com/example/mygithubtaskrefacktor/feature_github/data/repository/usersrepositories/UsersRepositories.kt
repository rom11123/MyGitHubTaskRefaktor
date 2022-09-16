package com.example.mygithubtaskrefacktor.feature_github.data.repository.usersrepositories

import com.example.mygithubtaskrefacktor.core.model.Resource
import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.AllUsersEntity
import kotlinx.coroutines.flow.Flow

interface UsersRepositories {
    fun getAllUsers(): Flow<Resource<List<AllUsersEntity>>>
}