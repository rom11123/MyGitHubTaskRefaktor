package com.example.mygithubtaskrefacktor.starter

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val starterModule = module {
    viewModel {
        StarterViewModel(
        loginUseCase = get()
        )
    }
}