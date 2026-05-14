package com.example.nopi_swirl.tugas_3

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nopi_swirl.databinding.ActivityThirdResultBinding
import com.example.nopi_swirl.tugas_2.SecondActivity
import com.example.nopi_swirl.tugas_4.FourthCustom1Activity
import com.example.nopi_swirl.tugas_4.FourthCustom2Activity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class ThirdResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdResultBinding

    private val title = "Dashboard"
    private val desc = "Selamat datang di aplikasi Nopi Swirl 👋"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnRumus.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("desc", desc)
            startActivity(intent)
        }
        binding.btnCustom1.setOnClickListener {
            val intent = Intent(this, FourthCustom1Activity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("desc", desc)
            startActivity(intent)
        }
        binding.btnCustom2.setOnClickListener {
            val intent = Intent(this, FourthCustom2Activity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("desc", desc)
            startActivity(intent)
        }
        binding.btnLogout.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Logout")
                .setMessage("Yakin ingin logout?")
                .setPositiveButton("Ya") { _, _ ->
                    val intent = Intent(this, ThirdActivity::class.java)
                    // Baris di bawah ini menghapus semua tumpukan Activity lama
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish() // Menutup Activity saat ini
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                    Snackbar.make(binding.root, "Logout dibatalkan", Snackbar.LENGTH_SHORT).show()
                }
                .show()
        }
    }
}