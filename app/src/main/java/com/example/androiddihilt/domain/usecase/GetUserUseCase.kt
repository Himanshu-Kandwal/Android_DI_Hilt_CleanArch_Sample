package com.example.androiddihilt.domain.usecase

import com.example.androiddihilt.data.util.UserResult
import com.example.androiddihilt.domain.model.User
import com.example.androiddihilt.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): User {
        return when (val result = userRepository.getUser()) {
            is UserResult.Success -> result.data
            is UserResult.Error -> throw result.e // Throw error if repository fails
        }
    }
}
