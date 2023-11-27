package com.example.fichachefapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class Inicial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicial)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.item_1 -> {
                    true
                }
                R.id.item_2 -> {
                    true
                }
                else -> false
            }
        }

        bottomNavigation.setOnItemReselectedListener { item ->
            when(item.itemId) {
                R.id.item_1 -> {
                }
                R.id.item_2 -> {
                }
            }
        }
    }
}
