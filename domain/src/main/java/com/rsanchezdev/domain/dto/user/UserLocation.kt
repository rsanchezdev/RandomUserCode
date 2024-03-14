package com.rsanchezdev.domain.dto.user

data class UserLocation(
    var street: UserStreet,
    val city: String,
    val state: String,
    val country: String,
    var postcode: Int,
    var coordinates: UserCoordinates,
    var timezone: UserTimezone
)