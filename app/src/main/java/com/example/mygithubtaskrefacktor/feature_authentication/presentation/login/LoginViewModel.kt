package com.example.mygithubtaskrefacktor.feature_authentication.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygithubtaskrefacktor.core.model.Resource
import com.example.mygithubtaskrefacktor.feature_authentication.domain.usecase.LoginUseCase
import com.example.mygithubtaskrefacktor.feature_authentication.presentation.mapper.errorCodeToMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {

    private val _errorMessage = MutableStateFlow("")
    val errorMessage: Flow<String> = _errorMessage

    private val _state = MutableStateFlow(LoginState())


     fun login() {
        val response = loginUseCase.logIn()
        response.onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = LoginState(data = result.data)
                }
                is Resource.Failure -> {
                    _state.value = LoginState(
                        error = result.exception.message ?: "An unexpected error occured"

                    )
                }
                is Resource.Loading -> {
                    _state.value = LoginState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun saveCredentials(email: String, password: String) {
        loginUseCase.saveEmail(email)
        loginUseCase.saveToken(password)
    }
    fun setToken(password: String) {
        loginUseCase.saveToken(password)
    }
    fun isLoggedIn(): Boolean = loginUseCase.isLoggedIn()

    fun fieldsAreEmpty(username: String, password: String) =
        username.isBlank() || password.isBlank()
    fun clear() = loginUseCase.clear()
}