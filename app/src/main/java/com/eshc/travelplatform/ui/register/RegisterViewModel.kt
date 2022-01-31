package com.eshc.travelplatform.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import com.eshc.travelplatform.data.repository.AuthRepository
import com.eshc.travelplatform.data.model.Result

import com.eshc.travelplatform.R

class RegisterViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val _registerForm = MutableLiveData<RegisterFormState>()
    val registerFormState: LiveData<RegisterFormState> = _registerForm

    private val _registerResult = MutableLiveData<RegisterResult>()
    val registerResult: LiveData<RegisterResult> = _registerResult

    fun register(username: String, password: String,phoneNum: String) {
        // can be launched in a separate asynchronous job
        val result = authRepository.register(username, password,phoneNum)

        if (result is Result.Success) {
            _registerResult.value =
                RegisterResult(success = RegisteredInUserView(displayName = result.data.displayName))
        } else {
            _registerResult.value = RegisterResult(error = R.string.login_failed)
        }
    }

    fun registerDataChanged(username: String, password: String,phoneNum:String) {
        if (!isUserNameValid(username)) {
            _registerForm.value = RegisterFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _registerForm.value = RegisterFormState(passwordError = R.string.invalid_password)
        } else if(!isPhoneNumValid(phoneNum)){
            _registerForm.value = RegisterFormState(phonenumError = R.string.invalid_phonenum)
        } else {
            _registerForm.value = RegisterFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

    // A placeholder password validation check
    private fun isPhoneNumValid(phoneNum: String): Boolean {
        return phoneNum.length > 10
    }
}