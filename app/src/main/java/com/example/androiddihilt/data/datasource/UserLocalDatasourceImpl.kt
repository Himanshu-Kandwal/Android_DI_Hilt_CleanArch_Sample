package com.example.androiddihilt.data.datasource

import com.example.androiddihilt.data.local.dao.UserDao
import com.example.androiddihilt.data.local.model.UserEntity
import javax.inject.Inject

class UserLocalDatasourceImpl @Inject constructor(val userDao: UserDao) : UserLocalDatasource {

    override suspend fun getLocalUser(): UserEntity {
        return userDao.getUser()
    }
}