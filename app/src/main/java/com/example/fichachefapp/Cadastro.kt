package com.example.fichachefapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.button.MaterialButton

class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        window.statusBarColor = Color.parseColor("#000000")

        val btnCadastrar = findViewById<MaterialButton>(R.id.btn_cadastrar)
        btnCadastrar.setOnClickListener {
            val intent = Intent(this, Inicial::class.java)
            startActivity(intent)
        }
    }
}
