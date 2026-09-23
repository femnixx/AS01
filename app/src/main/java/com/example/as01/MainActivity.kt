package com.example.as01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.as01.data.User
import com.example.as01.navigation.Screen
import com.example.as01.screens.AvatarScreen
import com.example.as01.screens.LoginScreen
import com.example.as01.screens.ProfileScreen
import com.example.as01.screens.RegistrationScreen
import com.example.as01.ui.theme.AS01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AS01Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Login) }
    var user by remember { mutableStateOf(User()) }

    when (currentScreen) {
        Screen.Login -> LoginScreen(
            onNavigateToRegistration = { currentScreen = Screen.Registration },
            onNavigateToProfile = { currentScreen = Screen.Profile }
        )
        Screen.Registration -> RegistrationScreen(
            onSave = { newUser ->
                user = newUser
                currentScreen = Screen.Profile
            },
            onNavigateToLogin = { currentScreen = Screen.Login }
        )
        Screen.Profile -> ProfileScreen(
            user = user,
            onNavigateToLogin = { currentScreen = Screen.Login },
            onNavigateToAvatar = { currentScreen = Screen.Avatar }
        )
        Screen.Avatar -> AvatarScreen(
            onBack = { currentScreen = Screen.Profile }
        )
    }
}