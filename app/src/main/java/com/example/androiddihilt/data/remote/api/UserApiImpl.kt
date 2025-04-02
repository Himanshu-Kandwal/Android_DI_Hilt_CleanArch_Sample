package com.example.androiddihilt.data.remote.api

import com.example.androiddihilt.data.remote.model.UserDto
import javax.inject.Inject

class UserApiImpl @Inject constructor() : UserApi {

    //dummy remote data
    val userDtoList = listOf(
        UserDto("Rohit Mehta", "rohit.mehta@example.com"),
        UserDto("Ananya Iyer", "ananya.iyer@example.com"),
        UserDto("John Smith", "john.smith@example.com"),
        UserDto("Sophia Brown", "sophia.brown@example.com"),
        UserDto("Rajesh Khanna", "rajesh.khanna@example.com"),
        UserDto("Emma Wilson", "emma.wilson@example.com"),
        UserDto("Kabir Gupta", "kabir.gupta@example.com"),
        UserDto("Olivia Martinez", "olivia.martinez@example.com"),
        UserDto("Vikram Choudhary", "vikram.choudhary@example.com"),
        UserDto("Ella Robinson", "ella.robinson@example.com")
    )


    override suspend fun getUser(): UserDto {
        val remoteUser = userDtoList.random()
        return remoteUser
    }
}