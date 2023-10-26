package com.example.fichachefapp

import android.graphics.Color
import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class Apresentacao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apresentacao)

        window.statusBarColor = Color.parseColor("#000000")

        val btnEntrar = findViewById<MaterialButton>(R.id.btnEntrar)
        btnEntrar.setOnClickListener {
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }

        val btnCadastro = findViewById<MaterialButton>(R.id.btnCadastrar)
        btnCadastro.setOnClickListener {
            val intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }
    }
}
