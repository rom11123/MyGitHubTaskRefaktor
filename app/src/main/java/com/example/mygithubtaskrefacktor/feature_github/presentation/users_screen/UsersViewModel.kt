package com.example.mygithubtaskrefacktor.feature_github.presentation.users_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygithubtaskrefacktor.core.model.Resource
import com.example.mygithubtaskrefacktor.feature_github.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class UsersViewModel(private val usersUseCase: GetUsersUseCase):ViewModel() {


    private val _state = MutableStateFlow(UsersState())
    val state: Flow<UsersState> = _state

    init {
        getUsers()
    }


    private fun getUsers() {
        usersUseCase.getUsers().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = UsersState(users = result.data)
                }
                is Resource.Failure -> {
                    _state.value = UsersState(
                        error = result.exception
                            .message?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = UsersState(isLoading = true)
                }
            }
        }.flowOn(Dispatchers.IO).launchIn(viewModelScope)
    }

}









