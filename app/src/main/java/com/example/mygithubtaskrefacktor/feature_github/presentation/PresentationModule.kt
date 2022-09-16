package com.example.mygithubtaskrefacktor.feature_github.presentation


import com.example.mygithubtaskrefacktor.feature_github.presentation.my_profile_screen.MyProfileViewModel
import com.example.mygithubtaskrefacktor.feature_github.presentation.repository_screen.TestRepoViewModel
import com.example.mygithubtaskrefacktor.feature_github.presentation.users_screen.UsersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel {
        UsersViewModel(usersUseCase = get())
    }


    viewModel{
        TestRepoViewModel(useCase = get())
    }

    viewModel {
        MyProfileViewModel(useCase = get())
    }




}