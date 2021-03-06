package com.eshc.domain.model

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class User(
    val userId: String,
    val displayName: String,
    val phoneNum: String? = null
)