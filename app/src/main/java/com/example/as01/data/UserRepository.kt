package com.example.as01.data

import android.content.Context
import android.content.SharedPreferences

object UserRepository {
    private const val PREFS_NAME = "user_prefs"
    private const val KEY_FIRST_NAME = "first_name"
    private const val KEY_LAST_NAME = "last_name"
    private const val KEY_USERNAME = "username"
    private const val KEY_EMAIL = "email"
    private const val KEY_PASSWORD = "password"
    private const val KEY_PHONE_NUMBER = "phone_number"
    private const val KEY_ADDRESS = "address"
    private const val KEY_DATE_OF_BIRTH = "date_of_birth"

    fun saveUser(context: Context, user: User) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().apply {
            putString(KEY_FIRST_NAME, user.firstName)
            putString(KEY_LAST_NAME, user.lastName)
            putString(KEY_USERNAME, user.username)
            putString(KEY_EMAIL, user.email)
            putString(KEY_PASSWORD, user.password)
            putString(KEY_PHONE_NUMBER, user.phoneNumber)
            putString(KEY_ADDRESS, user.address)
            putString(KEY_DATE_OF_BIRTH, user.dateOfBirth)
            apply()
        }
    }

    fun getUser(context: Context): User {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return User(
            firstName = prefs.getString(KEY_FIRST_NAME, "") ?: "",
            lastName = prefs.getString(KEY_LAST_NAME, "") ?: "",
            username = prefs.getString(KEY_USERNAME, "") ?: "",
            email = prefs.getString(KEY_EMAIL, "") ?: "",
            password = prefs.getString(KEY_PASSWORD, "") ?: "",
            phoneNumber = prefs.getString(KEY_PHONE_NUMBER, "Not set") ?: "Not set",
            address = prefs.getString(KEY_ADDRESS, "Not set") ?: "Not set",
            dateOfBirth = prefs.getString(KEY_DATE_OF_BIRTH, "Not set") ?: "Not set"
        )
    }

    fun clearUser(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit().clear().apply()
    }
}