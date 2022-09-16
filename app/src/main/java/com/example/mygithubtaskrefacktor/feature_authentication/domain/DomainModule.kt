package com.example.mygithubtaskrefacktor.feature_authentication.domain

import com.example.mygithubtaskrefacktor.feature_authentication.domain.usecase.LoginUseCase
import com.example.mygithubtaskrefacktor.feature_authentication.domain.usecase.LoginUseCaseImpl
import org.koin.dsl.module


val domainModule = module {

    single<LoginUseCase> { LoginUseCaseImpl(repository = get()) }
    }

