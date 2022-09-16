package com.example.mygithubtaskrefacktor.feature_github.domain.usecase

import com.example.mygithubtaskrefacktor.core.model.Resourcee
import com.example.mygithubtaskrefacktor.feature_github.data.entity.projectentity.RepositoryEntity
import com.example.mygithubtaskrefacktor.feature_github.data.repository.githubrepositories.MyRepository
import kotlinx.coroutines.flow.Flow


class MyRepoUseCase(private val repository: MyRepository) {

    operator fun invoke():Flow<Resourcee<List<RepositoryEntity>>> =
        repository.getAllUsers()
}




