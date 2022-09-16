package com.example.mygithubtaskrefacktor.feature_github.domain.usecase

import com.example.mygithubtaskrefacktor.core.model.Resource

import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.AllUsersEntity
import com.example.mygithubtaskrefacktor.feature_github.data.repository.usersrepositories.UsersRepositories
import kotlinx.coroutines.flow.Flow

class GetUsersUseCase(private val repository:UsersRepositories){

    fun getUsers():Flow<Resource<List<AllUsersEntity>>> = repository.getAllUsers()

}
