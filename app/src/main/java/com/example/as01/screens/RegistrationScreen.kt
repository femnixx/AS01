package com.example.as01.screens

import android.app.DatePickerDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.as01.data.User
import com.example.as01.ui.theme.Purple40
import com.example.as01.ui.theme.Typography
import java.util.Calendar

@Composable
fun RegistrationScreen(
    onSave: (User) -> Unit,
    onNavigateToLogin: () -> Unit,
    modifier: Modifier = Modifier
) {
    val firstName = remember { mutableStateOf("") }
    val lastName = remember { mutableStateOf("") }
    val username = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val phoneNumber = remember { mutableStateOf("") }
    val address = remember { mutableStateOf("") }
    val dateOfBirth = remember { mutableStateOf("") }
    val passwordVisible = remember { mutableStateOf(false) }
    val firstNameError = remember { mutableStateOf<String?>(null) }
    val lastNameError = remember { mutableStateOf<String?>(null) }
    val usernameError = remember { mutableStateOf<String?>(null) }
    val emailError = remember { mutableStateOf<String?>(null) }
    val passwordError = remember { mutableStateOf<String?>(null) }

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    val context = LocalContext.current

    val datePickerDialog = remember {
        DatePickerDialog(
            context,
            { _, selectedYear, selectedMonth, selectedDay ->
                val formattedMonth = String.format("%02d", selectedMonth + 1)
                val formattedDay = String.format("%02d", selectedDay)
                dateOfBirth.value = "$selectedDay/$formattedMonth/$selectedYear"
            },
            year,
            month,
            day
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Registrasi User",
            style = Typography.bodyLarge,
            color = Purple40
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = firstName.value,
            onValueChange = {
                firstName.value = it
                if (it.isNotBlank()) firstNameError.value = null
            },
            label = { Text("First Name") },
            isError = firstNameError.value != null,
            modifier = Modifier.fillMaxWidth()
        )
        if (firstNameError.value != null) {
            Text(
                text = firstNameError.value!!,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = lastName.value,
            onValueChange = {
                lastName.value = it
                if (it.isNotBlank()) lastNameError.value = null
            },
            label = { Text("Last Name") },
            isError = lastNameError.value != null,
            modifier = Modifier.fillMaxWidth()
        )
        if (lastNameError.value != null) {
            Text(
                text = lastNameError.value!!,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

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
            value = email.value,
            onValueChange = {
                email.value = it
                if (it.contains("@") && it.contains(".")) emailError.value = null
            },
            label = { Text("Email") },
            isError = emailError.value != null,
            modifier = Modifier.fillMaxWidth()
        )
        if (emailError.value != null) {
            Text(
                text = emailError.value!!,
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

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = phoneNumber.value,
            onValueChange = { phoneNumber.value = it },
            label = { Text("Phone Number") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = address.value,
            onValueChange = { address.value = it },
            label = { Text("Address") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = dateOfBirth.value,
            onValueChange = {},
            label = { Text("Date of Birth") },
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { datePickerDialog.show() }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                var valid = true
                if (firstName.value.isBlank()) {
                    firstNameError.value = "First Name is required"
                    valid = false
                }
                if (lastName.value.isBlank()) {
                    lastNameError.value = "Last Name is required"
                    valid = false
                }
                if (username.value.length < 3) {
                    usernameError.value = "Username must be at least 3 characters"
                    valid = false
                }
                if (!email.value.contains("@") || !email.value.contains(".")) {
                    emailError.value = "Enter a valid email"
                    valid = false
                }
                if (password.value.length < 8) {
                    passwordError.value = "Password must be at least 8 characters"
                    valid = false
                }
                if (valid) {
                    onSave(
                        User(
                            firstName = firstName.value,
                            lastName = lastName.value,
                            username = username.value,
                            email = email.value,
                            password = password.value,
                            phoneNumber = phoneNumber.value,
                            address = address.value,
                            dateOfBirth = dateOfBirth.value
                        )
                    )
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Save")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(onClick = onNavigateToLogin) {
            Text("Kembali ke Login")
        }
    }
}