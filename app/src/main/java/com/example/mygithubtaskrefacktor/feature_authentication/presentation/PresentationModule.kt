package com.example.mygithubtaskrefacktor.feature_authentication.presentation

import com.example.mygithubtaskrefacktor.feature_authentication.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val presentationModule = module {
    viewModel { LoginViewModel(loginUseCase = get()) }
}