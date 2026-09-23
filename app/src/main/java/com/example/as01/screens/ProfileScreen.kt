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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.VisualTransformation
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.as01.data.User
import com.example.as01.ui.theme.Purple40
import com.example.as01.ui.theme.Typography

@Composable
fun ProfileScreen(
    user: User,
    onNavigateToLogin: () -> Unit,
    onNavigateToAvatar: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF5F5F5))
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Profil User",
                style = Typography.bodyLarge,
                color = Purple40
            )

            Spacer(modifier = Modifier.height(24.dp))

            ProfileTextField(label = "First Name", value = user.firstName)
            Spacer(modifier = Modifier.height(8.dp))

            ProfileTextField(label = "Last Name", value = user.lastName)
            Spacer(modifier = Modifier.height(8.dp))

            ProfileTextField(label = "Username", value = user.username)
            Spacer(modifier = Modifier.height(8.dp))

            ProfileTextField(label = "Email", value = user.email)
            Spacer(modifier = Modifier.height(8.dp))

            ProfileTextField(label = "Password", value = user.password, visualTransformation = PasswordVisualTransformation())
            Spacer(modifier = Modifier.height(8.dp))

            ProfileTextField(label = "Phone Number", value = user.phoneNumber)
            Spacer(modifier = Modifier.height(8.dp))

            ProfileTextField(label = "Address", value = user.address)
            Spacer(modifier = Modifier.height(8.dp))

            ProfileTextField(label = "Date of Birth", value = user.dateOfBirth)
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = onNavigateToAvatar,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Lihat Avatar")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onNavigateToLogin,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Logout")
            }
        }
    }
}

@Composable
private fun ProfileTextField(label: String, value: String, visualTransformation: VisualTransformation = VisualTransformation.None) {
    OutlinedTextField(
        value = value,
        onValueChange = {},
        label = { Text(label) },
        readOnly = true,
        modifier = Modifier.fillMaxWidth(),
        visualTransformation = visualTransformation
    )
}