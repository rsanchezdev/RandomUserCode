package com.rsanchezdev.domain.dto.user

import java.io.Serializable

data class UserLocation(
    val street: UserStreet,
    val city: String,
    val state: String,
    val country: String,
    val postcode: Int,
    val coordinates: UserCoordinates,
    val timezone: UserTimezone
): Serializable