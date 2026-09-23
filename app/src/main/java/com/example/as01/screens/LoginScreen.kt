package com.example.as01.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.as01.ui.theme.Purple40
import com.example.as01.ui.theme.Typography

@Composable
fun LoginScreen(
    onNavigateToRegistration: () -> Unit,
    onNavigateToProfile: () -> Unit,
    modifier: Modifier = Modifier
) {
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }
    val usernameError = remember { mutableStateOf<String?>(null) }
    val passwordError = remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = "Login",
            style = Typography.bodyLarge,
            color = Purple40
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = username.value,
            onValueChange = {
                username.value = it
                if (it.length >= 3) usernameError.value = null
            },
            label = { Text("Username") },
            isError = usernameError.value != null,
            modifier = Modifier.fillMaxWidth()
        )
        if (usernameError.value != null) {
            Text(
                text = usernameError.value!!,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password.value,
            onValueChange = {
                password.value = it
                if (it.length >= 8) passwordError.value = null
            },
            label = { Text("Password") },
            visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                TextButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                    Text(if (passwordVisible.value) "Hide" else "Show")
                }
            },
            isError = passwordError.value != null,
            modifier = Modifier.fillMaxWidth()
        )
        if (passwordError.value != null) {
            Text(
                text = passwordError.value!!,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                var valid = true
                if (username.value.length < 3) {
                    usernameError.value = "Username must be at least 3 characters"
                    valid = false
                }
                if (password.value.length < 8) {
                    passwordError.value = "Password must be at least 8 characters"
                    valid = false
                }
                if (valid) onNavigateToProfile()
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(12.dp))

        TextButton(onClick = { /* TODO: forgot password */ }) {
            Text("Lupa Password")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = onNavigateToRegistration) {
            Text("Belum punya akun? Registrasi di sini")
        }
    }
}