package com.example.mygithubtaskrefacktor.feature_github.data.repository

import com.example.mygithubtaskrefacktor.feature_github.data.repository.githubrepositories.MyRepositoryImpl
import com.example.mygithubtaskrefacktor.feature_github.data.repository.githubrepositories.MyRepository
import com.example.mygithubtaskrefacktor.feature_github.data.repository.usersrepositories.UsersRepositories
import com.example.mygithubtaskrefacktor.feature_github.data.repository.usersrepositories.UsersRepositoriesImpl
import org.koin.dsl.module

val repositoriesModule = module {
    single <UsersRepositories>{ UsersRepositoriesImpl(usersLocalDataSource = get(), usersRemoteDataSource = get())}
    single <MyRepository>{ MyRepositoryImpl(remoteDataSource = get(), localDataSource = get()) }

}