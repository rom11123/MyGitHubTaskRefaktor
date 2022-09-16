package com.example.mygithubtaskrefacktor.feature_authentication.presentation.login

import com.example.mygithubtaskrefacktor.feature_authentication.data.entity.projectentity.GithubUserEntity

data class LoginState (
    val isLoading: Boolean = false,
    val data: GithubUserEntity? = null,
    val error: String = ""
        )