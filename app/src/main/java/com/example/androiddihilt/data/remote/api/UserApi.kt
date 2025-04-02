package com.example.androiddihilt.data.remote.api

import com.example.androiddihilt.data.local.model.UserEntity
import com.example.androiddihilt.data.remote.model.UserDto

interface UserApi {
    suspend fun getUser(): UserDto
}