package com.example.mygithubtaskrefacktor.feature_github.data.repository.githubrepositories

import com.example.mygithubtaskrefacktor.core.model.Resourcee
import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.RepositoryEntity
import kotlinx.coroutines.flow.Flow

interface MyRepository {
    fun getAllUsers(): Flow<Resourcee<List<RepositoryEntity>>>
}