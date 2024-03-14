package com.rsanchezdev.usecases.userslist

import com.rsanchezdev.data.users.UsersRepository
import com.rsanchezdev.domain.dto.RequestedItems
import com.rsanchezdev.domain.dto.user.User
import javax.inject.Inject

class RequestUsersListUseCase @Inject constructor(private val repository: UsersRepository) {

    suspend operator fun invoke(): RequestedItems<List<User>> {
        return repository.requestUsersList()
    }
}