package com.example.mygithubtaskrefacktor.feature_github.data.datasource

import com.example.mygithubtaskrefacktor.feature_github.data.datasource.localdatasource.allusersdatasource.UsersLocalDataSource
import com.example.mygithubtaskrefacktor.feature_github.data.datasource.localdatasource.allusersdatasource.UsersLocalDataSourceImpl
import com.example.mygithubtaskrefacktor.feature_github.data.datasource.localdatasource.repositorydatasource.RepositoriesLocalDataSource
import com.example.mygithubtaskrefacktor.feature_github.data.datasource.localdatasource.repositorydatasource.RepositoriesLocalDataSourceImpl
import com.example.mygithubtaskrefacktor.feature_github.data.datasource.remotedatasource.reporemotedatasource.RepoRemoteDataSource
import com.example.mygithubtaskrefacktor.feature_github.data.datasource.remotedatasource.reporemotedatasource.RepoRemoteDataSourceImpl
import com.example.mygithubtaskrefacktor.feature_github.data.datasource.remotedatasource.usersremotedatasource.UsersReMoteDataSourceImpl
import com.example.mygithubtaskrefacktor.feature_github.data.datasource.remotedatasource.usersremotedatasource.UsersRemoteDataSource
import org.koin.dsl.module

val dataSourceModule = module {
    single<UsersLocalDataSource> { UsersLocalDataSourceImpl(usersDao = get())}
    single <RepositoriesLocalDataSource>{RepositoriesLocalDataSourceImpl(repositoriesDao = get())}

    single<UsersRemoteDataSource>{UsersReMoteDataSourceImpl(api = get())}
    single<RepoRemoteDataSource>{RepoRemoteDataSourceImpl(api = get())}

}