package com.eshc.travelplatform.ui.register

data class RegisterFormState(
    val usernameError: Int? = null,
    val passwordError: Int? = null,
    val passwordCheckError: Int? = null,
    val isDataValid: Boolean = false
)