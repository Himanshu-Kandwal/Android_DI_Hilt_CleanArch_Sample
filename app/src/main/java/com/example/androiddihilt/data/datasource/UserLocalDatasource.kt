package com.example.androiddihilt.data.datasource

import com.example.androiddihilt.data.local.model.UserEntity

interface UserLocalDatasource {
    suspend fun getLocalUser(): UserEntity
}