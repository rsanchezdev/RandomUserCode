package com.rsanchezdev.data.users

import arrow.core.right
import com.rsanchezdev.data.users.datasource.UsersRemoteDataSource
import com.rsanchezdev.domain.dto.mocks.sampleUser
import com.rsanchezdev.domain.dto.user.Result
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class UsersRepositoryTest{

    @Mock
    lateinit var remoteDataSource: UsersRemoteDataSource

    private lateinit var usersRepository: UsersRepository

    private val remoteUsers = Result(listOf(sampleUser))

    @Before
    fun setUp(): Unit = runBlocking {
        whenever(remoteDataSource.getUsersList()).thenReturn(remoteUsers.right())
        usersRepository = UsersRepository(remoteDataSource)
    }

    @Test
    fun `Users are taken from remote data source`(): Unit = runBlocking {
        val result = usersRepository.requestUsersList().items
        assertEquals(remoteUsers.results, result)
    }

}