package com.example.androiddihilt.domain.repository

import com.example.androiddihilt.data.util.UserResult
import com.example.androiddihilt.domain.model.User


interface UserRepository {

    suspend fun getUser(): UserResult<User>
    suspend fun saveUser()
}