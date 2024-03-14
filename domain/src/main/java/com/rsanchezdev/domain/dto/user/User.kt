package com.rsanchezdev.domain.dto.user

import java.io.Serializable

data class User(
    val gender: String,
    val name: UserName,
    var location: UserLocation? = null,
    val email: String,
    val registered: UserRegistered,
    val phone: String,
    val picture: UserPicture
): Serializable