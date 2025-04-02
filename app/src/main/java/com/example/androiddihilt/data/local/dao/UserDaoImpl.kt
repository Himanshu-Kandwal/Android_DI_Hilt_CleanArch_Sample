package com.example.androiddihilt.data.local.dao

import com.example.androiddihilt.data.local.model.UserEntity
import javax.inject.Inject

class UserDaoImpl @Inject constructor() : UserDao {
    override suspend fun getUser(): UserEntity {
        val localUser = UserEntity("Local UserName", "local@gmail.com")
        return localUser
    }

}