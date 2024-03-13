package com.rsanchezdev.domain.dto.user

data class User(
    val gender: String,
    var userName: UserName,
    var userLocation: UserLocation,
    val email: String,
    var userRegistered: UserRegistered,
    val phone: String,
    var userPicture: UserPicture
)