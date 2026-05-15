package com.example.nopi_swirl

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.nopi_swirl.databinding.ActivityMainBinding
import com.example.nopi_swirl.AuthActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // SHARED PREFERENCES
        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
        val isLogin = sharedPref.getBoolean("isLogin", false)

        // CEK LOGIN
        if (!isLogin) {
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
            return
        }

        // BINDING
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // BUTTON WEBVIEW
        binding.btnWeb.setOnClickListener {

            startActivity(
                Intent(this, WebViewActivity::class.java)
            )
        }

        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Yakin ingin logout?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.commit()
                    dialog.dismiss()
                    startActivity(
                        Intent(this, AuthActivity::class.java)
                    )
                    finish()
                }
                .setNegativeButton("Tidak", null)
                .show()
        }
    }
}