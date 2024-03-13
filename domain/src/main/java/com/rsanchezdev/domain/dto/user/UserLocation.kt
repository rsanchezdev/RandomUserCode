package com.rsanchezdev.domain.dto.user

data class UserLocation(
    var userStreet: UserStreet,
    val city: String,
    val state: String,
    val country: String,
    var postcode: Int,
    var userCoordinates: UserCoordinates,
    var userTimezone: UserTimezone
)