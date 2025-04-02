package com.example.androiddihilt.data.repository

import com.example.androiddihilt.data.datasource.UserLocalDatasource
import com.example.androiddihilt.data.datasource.UserRemoteDatasource
import com.example.androiddihilt.data.mapper.toUser
import com.example.androiddihilt.domain.model.User
import com.example.androiddihilt.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    val userLocalDatasource: UserLocalDatasource,
    val userRemoteDatasource: UserRemoteDatasource
) : UserRepository {
    override suspend fun getUser(): User {
        return try {
            userRemoteDatasource.getRemoteUser().toUser()
        } catch (e: Exception) {
            userLocalDatasource.getLocalUser().toUser()
        }
    }

    override suspend fun saveUser() {
        TODO("Not yet implemented")
    }

}