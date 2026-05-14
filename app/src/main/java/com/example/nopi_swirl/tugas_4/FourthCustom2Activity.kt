package com.example.nopi_swirl.tugas_4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.nopi_swirl.R

class FourthCustom2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth_custom2)

        val title = intent.getStringExtra("TITLE")
        val desc = intent.getStringExtra("DESC")
    }
}