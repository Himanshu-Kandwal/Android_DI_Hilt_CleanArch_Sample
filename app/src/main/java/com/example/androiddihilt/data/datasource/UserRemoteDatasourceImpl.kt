package com.example.androiddihilt.data.datasource

import com.example.androiddihilt.data.remote.api.UserApi
import com.example.androiddihilt.data.remote.model.UserDto
import javax.inject.Inject

class UserRemoteDatasourceImpl @Inject constructor(val userApi: UserApi) : UserRemoteDatasource {
    override suspend fun getRemoteUser(): UserDto {
        return userApi.getUser()
    }
}