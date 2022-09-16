package com.example.mygithubtaskrefacktor.feature_github.data.mapper

import com.example.mygithubtaskrefacktor.core.mapper.Mapper
import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.AllUsersEntity
import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.RepositoryEntity
import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.UserEntity
import com.example.mygithubtaskrefacktor.feature_github.data.entity.response.AllUsersResponse
import com.example.mygithubtaskrefacktor.feature_github.data.entity.response.RepositoryResponse
import com.example.mygithubtaskrefacktor.feature_github.data.entity.response.UserResponse

val RESPONSE_TO_GITHUB_ALL_USERS = object : Mapper<AllUsersResponse, AllUsersEntity> {
    override fun map(s: AllUsersResponse): AllUsersEntity =
        AllUsersEntity(
            login = s.login ?: "", avatarUrl = s.avatarUrl ?: "", id = s.id ?: 0)
}

val RESPONSE_TO_REPOSITORY = object :Mapper<RepositoryResponse,RepositoryEntity> {
    override fun map(s: RepositoryResponse): RepositoryEntity =
        RepositoryEntity(
            id = s.id ?: 0,
            name = s.name ?: "",
            isPrivate = s.isPrivate ?: false,
            language = s.language ?: ""
        )
}

val RESPONSE_TO_USER = object :Mapper<UserResponse,UserEntity>{
    override fun map(s: UserResponse): UserEntity =
        UserEntity(username = s.username?:"",name = s.name?:"", email = s.email?:"")
}