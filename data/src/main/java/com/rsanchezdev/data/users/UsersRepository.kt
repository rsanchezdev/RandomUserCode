package com.rsanchezdev.data.users

import com.rsanchezdev.data.users.datasource.UsersRemoteDataSource
import com.rsanchezdev.domain.dto.RequestedItems
import com.rsanchezdev.domain.dto.user.User
import javax.inject.Inject

class UsersRepository @Inject constructor(private val remoteDataSource: UsersRemoteDataSource) {

    suspend fun requestUsersList(): RequestedItems<List<User>> {
        val requestedItems = RequestedItems<List<User>>()
        val users = remoteDataSource.getUsersList()
        users.fold(ifLeft = { requestedItems.error = it }) {
            requestedItems.items = it.results
        }
        return requestedItems
    }

}