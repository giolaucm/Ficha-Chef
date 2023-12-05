package com.example.fichachefapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.fragment.app.Fragment
import com.example.fichachefapp.databinding.ActivityPrincipalBinding
import com.example.fichachefapp.fragments.bottom_sheets

class Principal : AppCompatActivity() {
    private lateinit var binding: ActivityPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(MenuFragment())
        binding.bottomNavigation.background = null

        val btnCriarFicha = findViewById<FloatingActionButton>(R.id.floatingAdd)
        btnCriarFicha.setOnClickListener {
            val bottomSheet = bottom_sheets()
            bottomSheet.show(supportFragmentManager, "MyBottomSheetTag")
        }

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.item_1 -> replaceFragment(MenuFragment())
                R.id.item_2 -> replaceFragment(EstoqueFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.FrameLayout, fragment)
        fragmentTransaction.commit()
    }
}