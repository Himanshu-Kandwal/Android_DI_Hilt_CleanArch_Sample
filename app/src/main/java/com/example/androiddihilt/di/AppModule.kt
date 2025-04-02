package com.example.androiddihilt.di

import com.example.androiddihilt.data.datasource.UserLocalDatasource
import com.example.androiddihilt.data.datasource.UserLocalDatasourceImpl
import com.example.androiddihilt.data.datasource.UserRemoteDatasource
import com.example.androiddihilt.data.datasource.UserRemoteDatasourceImpl
import com.example.androiddihilt.data.local.dao.UserDao
import com.example.androiddihilt.data.local.dao.UserDaoImpl
import com.example.androiddihilt.data.remote.api.UserApi
import com.example.androiddihilt.data.remote.api.UserApiImpl
import com.example.androiddihilt.data.repository.UserRepositoryImpl
import com.example.androiddihilt.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

    @Binds
    @Singleton
    abstract fun bindsUserLocalDataSource(userLocalDatasourceImpl: UserLocalDatasourceImpl): UserLocalDatasource

    @Binds
    @Singleton
    abstract fun bindsUserRemoteDataSource(userRemoteDatasourceImpl: UserRemoteDatasourceImpl): UserRemoteDatasource

    @Binds
    @Singleton
    abstract fun bindsUserApi(userApiImpl: UserApiImpl): UserApi

    @Binds
    @Singleton
    abstract fun bindsUserDao(userDaoImpl: UserDaoImpl): UserDao

}

/*

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

    @Binds
    @Singleton
    abstract fun bindUserLocalDataSource(
        userLocalDatasourceImpl: UserLocalDatasourceImpl
    ): UserLocalDatasource

    @Binds
    @Singleton
    abstract fun bindUserRemoteDataSource(
        userRemoteDatasourceImpl: UserRemoteDatasourceImpl
    ): UserRemoteDatasource
 */