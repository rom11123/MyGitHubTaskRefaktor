package com.example.mygithubtaskrefacktor.feature_authentication.data

import com.example.mygithubtaskrefacktor.feature_authentication.data.datasource.localdatasource.LoginLocalDataSource
import com.example.mygithubtaskrefacktor.feature_authentication.data.datasource.localdatasource.LoginLocalDataSourceImpl
import com.example.mygithubtaskrefacktor.feature_authentication.data.datasource.remotedatasource.LoginRemoteDataSource
import com.example.mygithubtaskrefacktor.feature_authentication.data.datasource.remotedatasource.LoginRemoteDataSourceImpl
import com.example.mygithubtaskrefacktor.feature_authentication.data.repository.LoginRepository
import com.example.mygithubtaskrefacktor.feature_authentication.data.repository.LoginRepositoryImpl
import org.koin.dsl.module

val dataModule = module {
    single<LoginLocalDataSource> { LoginLocalDataSourceImpl(sharedPreferences = get()) }

    single<LoginRemoteDataSource> { LoginRemoteDataSourceImpl(api = get()) }

    single<LoginRepository> {
        LoginRepositoryImpl(
            loginLocalDataSource = get(),
            loginRemoteDataSource = get()
        )
    }

}
