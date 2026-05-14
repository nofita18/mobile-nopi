package com.example.nopi_swirl

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.nopi_swirl.tugas_7.BaseActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash_screen)

        val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)

        lifecycleScope.launch {
            delay(2000)
            val isLogin = sharedPref.getBoolean("isLogin", false)
            if (isLogin) {
                startActivity(
                    Intent(
                        this@SplashScreenActivity,
                        BaseActivity::class.java
                    )
                )
            } else {
                startActivity(
                    Intent(
                        this@SplashScreenActivity,
                        AuthActivity::class.java
                    )
                )
            }
            finish()
        }
    }
}