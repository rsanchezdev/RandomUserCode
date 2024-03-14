package com.rsanchezdev.domain.dto.user

import java.io.Serializable
import java.util.Date

data class UserRegistered(
    val date: Date,
    val age: Int
): Serializable