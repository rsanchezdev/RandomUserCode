package com.rsanchezdev.domain.dto.user

data class User(
    val gender: String,
    var name: UserName,
    var location: UserLocation,
    val email: String,
    var registered: UserRegistered,
    val phone: String,
    var picture: UserPicture
)