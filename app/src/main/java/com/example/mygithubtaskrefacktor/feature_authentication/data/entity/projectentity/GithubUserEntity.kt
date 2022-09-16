package com.example.mygithubtaskrefacktor.feature_authentication.data.entity.projectentity

data class GithubUserEntity(
    val login: String = "",
    val name: String = "",
    val email: String = "",
    val url: String = "",
    val subscriptionsUrl: String = "",
    val followers: Int = 0,
    val following: Int = 0
) {
}