package com.example.nopiswirl.auth

import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.nopi_swirl.databinding.ActivityRegisterBinding
import com.example.nopiswirl.data.PrefManager

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var pref: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pref = PrefManager(this)

        binding.btnRegister.setOnClickListener {
            validateRegisterForm()
        }

        binding.tvLogin.setOnClickListener {
            finish() // kembali ke login
        }
    }

    private fun validateRegisterForm() {

        val nama = binding.etNama.text.toString().trim()
        val email = binding.etEmailRegister.text.toString().trim()
        val password = binding.etPasswordRegister.text.toString().trim()
        val confirm = binding.etConfirmPassword.text.toString().trim()

        var valid = true

        binding.etNama.error = null
        binding.etEmailRegister.error = null
        binding.etPasswordRegister.error = null
        binding.etConfirmPassword.error = null

        // Validasi field kosong
        if (nama.isEmpty()) {
            binding.etNama.error = "Nama wajib diisi"
            valid = false
        }

        if (email.isEmpty()) {
            binding.etEmailRegister.error = "Email wajib diisi"
            valid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.etEmailRegister.error = "Format email tidak valid"
            valid = false
        }

        if (password.isEmpty()) {
            binding.etPasswordRegister.error = "Password wajib diisi"
            valid = false
        } else if (password.length < 6) {
            binding.etPasswordRegister.error = "Password minimal 6 karakter"
            valid = false
        }

        if (confirm.isEmpty()) {
            binding.etConfirmPassword.error = "Konfirmasi password wajib diisi"
            valid = false
        } else if (password != confirm) {
            binding.etConfirmPassword.error = "Password tidak sama"
            valid = false
        }

        if (!valid) return

        // 🔥 SIMPAN KE SHARED PREFERENCES
        pref.saveUser(nama, email, password)

        finish() // balik ke login setelah register sukses
    }
}