package com.example.androiddihilt.data.local.dao

import com.example.androiddihilt.data.local.model.UserEntity

interface UserDao {
    suspend fun getUser(): UserEntity
}