package com.example.mygithubtaskrefacktor.feature_authentication.mapper

import com.example.mygithubtaskrefacktor.core.mapper.Mapper
import com.example.mygithubtaskrefacktor.feature_authentication.data.entity.projectentity.GithubUserEntity
import com.example.mygithubtaskrefacktor.feature_authentication.data.entity.response.GithubUserResponse

val RESPONSE_TO_GITHUB_USER = object : Mapper<GithubUserResponse, GithubUserEntity> {
    override fun map(s: GithubUserResponse): GithubUserEntity =
        GithubUserEntity(
            login = s.login ?: "", url = s.url ?: "",subscriptionsUrl =  s.subscriptionsUrl ?: "",
            followers = s.followers ?: 0, following = s.following ?: 0,name = s.name?:"",email = s.email?:""
        )
}