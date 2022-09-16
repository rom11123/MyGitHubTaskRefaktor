package com.example.mygithubtaskrefacktor.feature_github.presentation.repository_screen

import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.RepositoryEntity

data class RepositoryState (
    val isLoading: Boolean = false,
    val data: List<RepositoryEntity> = emptyList(),
    val error: String = ""
        )