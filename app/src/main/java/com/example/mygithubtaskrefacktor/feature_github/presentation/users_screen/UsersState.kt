package com.example.mygithubtaskrefacktor.feature_github.presentation.users_screen

import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.AllUsersEntity

data class UsersState  (
    val isLoading: Boolean = false,
    val users: List<AllUsersEntity> = emptyList(),
    val error: String = ""
)
