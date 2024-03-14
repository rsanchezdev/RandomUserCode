package com.rsanchezdev.randomusercode.data.server.users

import arrow.core.Either
import com.rsanchezdev.data.users.datasource.UsersRemoteDataSource
import com.rsanchezdev.domain.dto.user.Result
import com.rsanchezdev.domain.dto.Error
import com.rsanchezdev.randomusercode.data.tryCall
import javax.inject.Inject

class UsersServerDataSource @Inject constructor(private val remoteService: RemoteService): UsersRemoteDataSource {

    override suspend fun getUsersList(): Either<Error, Result> = tryCall {
        remoteService.listUsers()
    }
}