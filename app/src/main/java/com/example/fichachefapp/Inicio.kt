package com.example.fichachefapp

import android.graphics.Color
import android.os.Bundle
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        window.statusBarColor = Color.parseColor("#000000")

        val btnEntrarTela = findViewById<MaterialButton>(R.id.btnEntrarTela)
        btnEntrarTela.setOnClickListener {
            val intent = Intent(this, Entrar::class.java)
            startActivity(intent)
        }

        val btnCadastroTela = findViewById<MaterialButton>(R.id.btnCadastrarTela)
        btnCadastroTela.setOnClickListener {
            val intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }
    }
}

