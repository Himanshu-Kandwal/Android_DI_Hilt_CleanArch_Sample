package com.example.androiddihilt.data.local.dao

import com.example.androiddihilt.data.local.model.UserEntity
import javax.inject.Inject

class UserDaoImpl @Inject constructor() : UserDao {

    val userEntityList = listOf(
        UserEntity("Deepak Soni", "deepak.soni@example.com"),
        UserEntity("Simran Kaur", "simran.kaur@example.com"),
        UserEntity("Daniel Johnson", "daniel.johnson@example.com"),
        UserEntity("Mia Davis", "mia.davis@example.com"),
        UserEntity("Arun Nair", "arun.nair@example.com"),
        UserEntity("Charlotte Thompson", "charlotte.thompson@example.com"),
        UserEntity("Manoj Patil", "manoj.patil@example.com"),
        UserEntity("Ava White", "ava.white@example.com"),
        UserEntity("Sandeep Yadav", "sandeep.yadav@example.com"),
        UserEntity("Liam Harris", "liam.harris@example.com")
    )

    override suspend fun getUser(): UserEntity {

        return userEntityList.random()
    }

}