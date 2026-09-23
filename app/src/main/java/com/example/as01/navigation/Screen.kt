package com.example.as01.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Registration : Screen("registration")
    object Profile : Screen("profile")
    object Avatar : Screen("avatar")
}