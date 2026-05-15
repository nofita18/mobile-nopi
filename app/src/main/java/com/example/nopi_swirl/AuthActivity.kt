package com.example.nopi_swirl

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nopi_swirl.databinding.ActivityAuthBinding
import com.example.nopi_swirl.tugas_7.BaseActivity
import com.example.nopiswirl.auth.RegisterActivity
import com.example.nopiswirl.data.PrefManager

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding
    private lateinit var pref: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = PrefManager(this)

        binding.btnLogin.setOnClickListener {
            validateLogin()
        }

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    private fun validateLogin() {

        val username = binding.etUsername.text.toString().trim()
        val password = binding.etPassword.text.toString().trim()

        var valid = true
        binding.etUsername.error = null
        binding.etPassword.error = null

        if (username.isEmpty()) {
            binding.etUsername.error = "Username wajib diisi"
            valid = false
        }

        if (password.isEmpty()) {
            binding.etPassword.error = "Password wajib diisi"
            valid = false
        }

        if (!valid) return

        val savedEmail = pref.getEmail()
        val savedPassword = pref.getPassword()

        // RULE LOGIN
        val loginSuccess =
            (username == password) ||
                    (username == savedEmail && password == savedPassword)

        if (loginSuccess) {
            startActivity(Intent(this, BaseActivity::class.java))
            finish()
        } else {
            binding.etPassword.error = "Username atau Password salah"
        }
    }
}