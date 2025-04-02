package com.example.androiddihilt.core.util

import com.example.androiddihilt.ui.model.UserUI

sealed class Result<out T> {
    object Loading : Result<Nothing>()
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val e: Throwable, val msg: String = "Some error occurred") : Result<Nothing>()
}