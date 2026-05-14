package com.example.nopi_swirl.tugas_7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.nopi_swirl.R
import com.example.nopi_swirl.databinding.ActivityBaseBinding

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TOOLBAR
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Bina Desa"

        // DEFAULT FRAGMENT
        replaceFragment(HomeFragment())

        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.home -> {
                    replaceFragment(HomeFragment())
                    supportActionBar?.title = "Home"
                    true
                }

                R.id.about -> {
                    replaceFragment(AboutFragment())
                    supportActionBar?.title = "About"
                    true
                }

                R.id.profile -> {
                    replaceFragment(ProfileFragment())
                    supportActionBar?.title = "Profile"
                    true
                }

                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }
}