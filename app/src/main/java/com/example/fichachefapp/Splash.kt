package com.example.fichachefapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splash : AppCompatActivity(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()
        window.statusBarColor = Color.parseColor("#FFFFFF")

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, Inicio::class.java)
            startActivity(intent)
            finish()
        },5000)
    }
}