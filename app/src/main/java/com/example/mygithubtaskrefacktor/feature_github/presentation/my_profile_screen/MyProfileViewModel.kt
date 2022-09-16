package com.example.mygithubtaskrefacktor.feature_github.presentation.my_profile_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygithubtaskrefacktor.core.model.Resource
import com.example.mygithubtaskrefacktor.feature_authentication.domain.usecase.LoginUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MyProfileViewModel(private val useCase: LoginUseCase) : ViewModel() {
    private val _state = MutableStateFlow(MyProfileState())
    val state: Flow<MyProfileState> = _state

  val logOutEvent = MutableStateFlow(Unit)


    init {
        getUserProfile()

    }

    private fun getUserProfile() {
        useCase.logIn().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = MyProfileState(user = result.data)
                }
                is Resource.Failure -> {
                    _state.value = MyProfileState(
                        error = result.exception.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = MyProfileState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


    fun logout() {
      logOutEvent.value =   useCase.clear()

    }

}