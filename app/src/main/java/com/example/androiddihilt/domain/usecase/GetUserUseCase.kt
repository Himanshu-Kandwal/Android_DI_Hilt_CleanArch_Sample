package com.example.androiddihilt.domain.usecase

import com.example.androiddihilt.domain.model.User
import com.example.androiddihilt.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetUserUseCase @Inject constructor(val userRepository: UserRepository) {
    suspend operator fun invoke(): User {
        return userRepository.getUser()
    }
}