package com.eshc.travelplatform.ui.register

/**
 * Data validation state of the login form.
 */
data class RegisterFormState(
    val usernameError: Int? = null,
    val passwordError: Int? = null,
    val phonenumError: Int? = null,
    val isDataValid: Boolean = false
)