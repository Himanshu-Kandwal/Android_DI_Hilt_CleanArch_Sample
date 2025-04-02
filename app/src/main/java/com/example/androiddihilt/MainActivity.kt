package com.example.androiddihilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddihilt.core.util.Result
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
                    val userState = viewModel.userState.collectAsState()
                    when (val result =
                        userState.value) {
                        is Result.Success -> {
                            val user = result.data
                            Greeting(name = user.name, modifier = Modifier.padding(innerPadding))
                        }

                        is Result.Error -> {
                            val errorMessage = result.msg
                            Text(
                                text = "Error: $errorMessage",
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        Result.Loading -> {
                            Text(text = "Loading...", modifier = Modifier.padding(innerPadding))
                        }
                    }

                }

            }
        }


    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Android_DI_HiltTheme {
        Greeting("Android")
    }
}