package com.example.mygithubtaskrefacktor.feature_github.presentation.repository_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mygithubtaskrefacktor.core.model.Resourcee
import com.example.mygithubtaskrefacktor.feature_github.domain.usecase.MyRepoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class TestRepoViewModel(private val useCase:MyRepoUseCase):ViewModel() {

    private val _state = MutableStateFlow(RepositoryState())
    val state: Flow<RepositoryState> = _state

    init {
        getRepos()
    }

    private fun getRepos() {
        useCase().onEach { result ->
            when (result) {
                is Resourcee.Success -> {
                    _state.value = RepositoryState(data = result.data ?: emptyList())
                }
                is Resourcee.Error -> {
                    _state.value = RepositoryState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resourcee.Loading -> {
                    _state.value = RepositoryState(isLoading = true)
                }
            }
        }.flowOn(Dispatchers.IO).launchIn(viewModelScope)
    }
}