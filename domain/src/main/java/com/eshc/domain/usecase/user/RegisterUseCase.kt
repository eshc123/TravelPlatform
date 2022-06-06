package com.eshc.domain.usecase.user

import com.eshc.domain.repository.UserRepository

class RegisterUseCase(private val userRepository : UserRepository) {
    suspend operator fun invoke(userId : String,password : String)  {
        return userRepository.register(userId,password)
    }
}