package com.example.mygithubtaskrefacktor.starter

import androidx.lifecycle.ViewModel
import com.example.mygithubtaskrefacktor.core.viewmodel.SingleLiveEventData
import com.example.mygithubtaskrefacktor.feature_authentication.domain.usecase.LoginUseCase

class StarterViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    val isAuthenticated = SingleLiveEventData<Boolean>()
    init {
        checkIsAuthenticated()
    }

    fun checkIsAuthenticated() {
        isAuthenticated.value = loginUseCase.isLoggedIn()
    }

}