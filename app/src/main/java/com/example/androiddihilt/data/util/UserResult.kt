package com.example.androiddihilt.data.util

sealed class UserResult<out T> {
    data class Success<T>(val data: T) : UserResult<T>()
    data class Error(val e: Throwable, val msg: String = "Some error occurred") : UserResult<Nothing>()
}