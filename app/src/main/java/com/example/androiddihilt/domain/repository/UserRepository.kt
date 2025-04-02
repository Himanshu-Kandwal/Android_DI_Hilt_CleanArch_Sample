package com.example.androiddihilt.domain.repository

import com.example.androiddihilt.domain.model.User


interface UserRepository {

    suspend fun getUser(): User
    suspend fun saveUser()
}