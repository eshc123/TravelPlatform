package com.eshc.travelplatform.ui.register

data class RegisterResult(
    val success: RegisteredInUserView? = null,
    val error: Int? = null
)