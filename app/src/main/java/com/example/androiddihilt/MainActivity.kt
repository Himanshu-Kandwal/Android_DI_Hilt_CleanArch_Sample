package com.example.androiddihilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.androiddihilt.ui.screen.MainScreen
import com.example.androiddihilt.ui.theme.Android_DI_HiltTheme
import com.example.androiddihilt.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            Android_DI_HiltTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        viewModel,
                        onLoadUserButtonClick = { viewModel.fetchUser() },
                        modifier = Modifier.padding(innerPadding)
                    )
                }

            }
        }

    }
}
