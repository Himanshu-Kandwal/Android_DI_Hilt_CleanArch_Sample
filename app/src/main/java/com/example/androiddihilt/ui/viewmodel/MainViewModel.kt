package com.example.androiddihilt.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddihilt.domain.usecase.GetUserUseCase
import com.example.androiddihilt.ui.mapper.toUserUi
import com.example.androiddihilt.ui.model.UserUI
import com.example.androiddihilt.ui.util.UserState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userUseCase: GetUserUseCase
) : ViewModel() {

    private val _userState = MutableStateFlow<UserState<UserUI>>(UserState.Loading)

    val userState = _userState
        .onStart { fetchUser() }
        .distinctUntilChanged()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            UserState.Loading
        )


    fun fetchUser() {
        viewModelScope.launch {
            _userState.value = UserState.Loading
            delay(5000)
            _userState.value = try {
                val user = userUseCase()
                UserState.Success(user.toUserUi())
            } catch (e: Exception) {
                UserState.Error(e, "Unknown error")
            }
        }
    }


}
