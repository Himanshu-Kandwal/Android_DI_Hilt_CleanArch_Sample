package com.example.androiddihilt.data.remote.api

import com.example.androiddihilt.data.remote.model.UserDto
import javax.inject.Inject

class UserApiImpl @Inject constructor() : UserApi {
    override suspend fun getUser(): UserDto {
        val remoteUser = UserDto("Remote UserName", "remote@gmail.com")
        return remoteUser
    }
}