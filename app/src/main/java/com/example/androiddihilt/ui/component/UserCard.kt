package com.example.androiddihilt.ui.component

import androidx.compose.runtime.Composable

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UserCard(name: String, email: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge, // Larger text for the name
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = email,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f) // Slightly muted email text
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserCardPreview() {
    MaterialTheme {
        UserCard(name = "John Doe", email = "john.doe@example.com")
    }
}