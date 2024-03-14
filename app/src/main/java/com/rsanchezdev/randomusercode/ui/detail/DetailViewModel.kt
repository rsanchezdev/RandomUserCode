package com.rsanchezdev.randomusercode.ui.detail

import androidx.lifecycle.ViewModel
import com.rsanchezdev.domain.dto.user.User
import com.rsanchezdev.randomusercode.di.UserDI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(@UserDI private val user: User) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    init {
        _state.value = UiState(user)
    }

    data class UiState(val user: User? = null)
}