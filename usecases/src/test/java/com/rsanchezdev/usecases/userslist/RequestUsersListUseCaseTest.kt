package com.rsanchezdev.usecases.userslist

import com.rsanchezdev.data.users.UsersRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class RequestUsersListUseCaseTest{
    @Test
    fun `Invoke calls users repository`(): Unit = runBlocking {
        val usersRepository = mock<UsersRepository>()
        val requestUsersListUseCase = RequestUsersListUseCase(usersRepository)

        requestUsersListUseCase()

        verify(usersRepository).requestUsersList()
    }
}