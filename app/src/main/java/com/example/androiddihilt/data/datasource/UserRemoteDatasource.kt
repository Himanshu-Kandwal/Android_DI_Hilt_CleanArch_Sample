package com.example.androiddihilt.data.datasource

import com.example.androiddihilt.data.remote.model.UserDto

interface UserRemoteDatasource {
    suspend fun getRemoteUser(): UserDto
}