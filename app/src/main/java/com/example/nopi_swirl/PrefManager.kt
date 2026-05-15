package com.example.nopiswirl.data

import android.content.Context

class PrefManager(context: Context) {

    private val pref = context.getSharedPreferences("USER_PREF", Context.MODE_PRIVATE)
    private val editor = pref.edit()

    companion object {
        private const val KEY_NAMA = "NAMA"
        private const val KEY_EMAIL = "EMAIL"
        private const val KEY_PASSWORD = "PASSWORD"
    }

    fun saveUser(nama: String, email: String, password: String) {
        editor.putString(KEY_NAMA, nama)
        editor.putString(KEY_EMAIL, email)
        editor.putString(KEY_PASSWORD, password)
        editor.apply()
    }

    fun getEmail(): String? = pref.getString(KEY_EMAIL, null)
    fun getPassword(): String? = pref.getString(KEY_PASSWORD, null)
}