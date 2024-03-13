package com.rsanchezdev.domain.dto

data class RequestedItems<T>(
    var items: T? = null,
    var error: Error? = null
)
