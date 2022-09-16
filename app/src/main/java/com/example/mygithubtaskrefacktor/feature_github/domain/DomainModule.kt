package com.example.mygithubtaskrefacktor.feature_github.domain

import com.example.mygithubtaskrefacktor.feature_github.domain.usecase.GetUsersUseCase
import com.example.mygithubtaskrefacktor.feature_github.domain.usecase.MyRepoUseCase
import org.koin.dsl.module

val doMainModule = module {


    single { GetUsersUseCase(repository = get()) }
    single { MyRepoUseCase(repository = get()) }


//    factory {
//        GetUsersUseCase(
//            coroutineDispatcher = get(qualifier = named(DispatchersName.IO)),
//            usersRepositories = get(),
//        )
//    }
//
//    factory {
//        GetRepositoriesUseCase(
//            coroutineDispatcher = get(qualifier = named(DispatchersName.IO)),
//            repository = get(),
//        )
//    }


}