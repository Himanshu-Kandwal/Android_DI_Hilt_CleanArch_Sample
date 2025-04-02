package com.example.androiddihilt.ui.util

sealed class UserState<out T> {
    object Loading : UserState<Nothing>()
    data class Success<T>(val data: T) : UserState<T>()
    data class Error(val e: Throwable, val msg: String = "Some error occurred") : UserState<Nothing>()
}