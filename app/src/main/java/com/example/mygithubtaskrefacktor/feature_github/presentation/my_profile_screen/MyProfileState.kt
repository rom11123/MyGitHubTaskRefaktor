package com.example.mygithubtaskrefacktor.feature_github.presentation.my_profile_screen

import com.example.mygithubtaskrefacktor.feature_authentication.data.entity.projectentity.GithubUserEntity

data class MyProfileState(
    val isLoading: Boolean = false,
    val user: GithubUserEntity? = null,
    val error: String = ""
)
