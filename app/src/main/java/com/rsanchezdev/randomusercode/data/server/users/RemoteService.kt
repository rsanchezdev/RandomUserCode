package com.rsanchezdev.randomusercode.data.server.users

import com.rsanchezdev.domain.dto.user.Result
import retrofit2.http.GET

interface RemoteService {

    @GET("?nat=es&results=30&inc=name,email,gender,phone,registered,location,picture")
    suspend fun listUsers(): Result

}