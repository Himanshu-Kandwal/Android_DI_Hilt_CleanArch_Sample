package com.example.androiddihilt.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddihilt.core.util.Result
import com.example.androiddihilt.domain.model.User
import com.example.androiddihilt.domain.repository.UserRepository
import com.example.androiddihilt.domain.usecase.GetUserUseCase
import com.example.androiddihilt.ui.mapper.toUserUi
import com.example.androiddihilt.ui.model.UserUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userUseCase: GetUserUseCase
) : ViewModel() {

    private val _userState = MutableStateFlow<Result<UserUI>>(Result.Loading)
    val userState: StateFlow<Result<UserUI>> = _userState.asStateFlow()

    init {
        fetchUser()
    }

    fun fetchUser() {
        viewModelScope.launch {
            _userState.value = Result.Loading
            delay(5000) // Simulating delay
            _userState.value = try {
                val user = userUseCase()
                Result.Success(user.toUserUi()) // Convert to UI model
            } catch (e: Exception) {
                Result.Error(e, "Unknown error")
            }
        }
    }
}
