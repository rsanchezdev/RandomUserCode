package com.rsanchezdev.randomusercode.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rsanchezdev.domain.dto.RequestedItems
import com.rsanchezdev.domain.dto.user.User
import com.rsanchezdev.usecases.userslist.RequestUsersListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainViewModel@Inject constructor(
    private val requestUsersListUseCase: RequestUsersListUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _state.asStateFlow()

    private val _originalUsersList = MutableStateFlow<List<User>>(listOf())
    private val originalUsersList: StateFlow<List<User>> = _originalUsersList.asStateFlow()

    private val _filteredUsersList = MutableStateFlow<List<User>>(listOf())

    fun onUiReady() {
        viewModelScope.launch {
            _state.value = _state.value.copy(loading = true)
            val requestedItems = requestUsersListUseCase.invoke()
            requestedItems.items?.let {
                _originalUsersList.value = it
                _filteredUsersList.value = it
            }
            _state.value = _state.value.copy(loading = false, requestedItems = requestedItems)
        }
    }

    fun getUserListFiltered(searchText: String? = ""): List<User> {
        return if (searchText == "" || searchText.isNullOrEmpty()){
            originalUsersList.value
        } else {
            _filteredUsersList.value = originalUsersList.value.filter { user ->
                val userName = "${user.name.first} ${user.name.last}"
                userName.contains(searchText, true) || user.email.contains(searchText, true)
            }
            _filteredUsersList.value
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val requestedItems: RequestedItems<List<User>> = RequestedItems()
    )
}