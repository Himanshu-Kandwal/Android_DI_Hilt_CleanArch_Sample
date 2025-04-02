package com.example.androiddihilt.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.androiddihilt.ui.component.UserCard
import com.example.androiddihilt.ui.model.UserUI
import com.example.androiddihilt.core.util.Result
import com.example.androiddihilt.ui.viewmodel.MainViewModel

@Composable
fun MainScreen(
    userState: Result<UserUI>,
    onLoadUserButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            when (userState) {
                is Result.Success -> {
                    val user = userState.data
                    UserCard(name = user.name, email = user.email)
                }

                is Result.Error -> {
                    Text(text = "Error: ${userState.msg}")
                }

                Result.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.size(64.dp),
                        color = MaterialTheme.colorScheme.secondary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    )
                }
            }

            Button(
                onClick = onLoadUserButtonClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Text(text = "Load User")
            }
        }
    }
}

@Composable
fun MainScreen(
    mainViewModel: MainViewModel,
    onLoadUserButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val userState = mainViewModel.userState.collectAsStateWithLifecycle().value
    MainScreen(userState = userState, onLoadUserButtonClick, modifier = modifier)
}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    MainScreen(
        userState = Result.Success(UserUI("John Doe", "john.doe@example.com")),
        onLoadUserButtonClick = {})
}