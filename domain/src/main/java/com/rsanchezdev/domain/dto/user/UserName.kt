package com.rsanchezdev.domain.dto.user

import java.io.Serializable

data class UserName(
    val title: String,
    val first: String,
    val last: String
): Serializable