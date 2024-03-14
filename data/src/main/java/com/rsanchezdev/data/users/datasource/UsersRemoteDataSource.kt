package com.rsanchezdev.data.users.datasource

import arrow.core.Either
import com.rsanchezdev.domain.dto.user.Result
import com.rsanchezdev.domain.dto.Error

interface UsersRemoteDataSource {
    suspend fun getUsersList(): Either<Error, Result>
}