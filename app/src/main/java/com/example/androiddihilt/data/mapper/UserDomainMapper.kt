package com.example.androiddihilt.data.mapper

import com.example.androiddihilt.data.local.model.UserEntity
import com.example.androiddihilt.data.remote.model.UserDto
import com.example.androiddihilt.domain.model.User

fun UserDto.toUser(): User {
    return User(name, email)
}

fun UserEntity.toUser(): User {
    return User(name, email)
}