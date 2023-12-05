package com.example.fichachefapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fichachefapp.ui.activity.Ingredientes

class Markup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_markup)

        val btnProximo= findViewById<Button>(R.id.btn_proximo)
        btnProximo.setOnClickListener {
            val intent = Intent(this, FichaFinal::class.java)
            startActivity(intent)
        }

        val btnVoltar= findViewById<Button>(R.id.btn_voltar)
        btnVoltar.setOnClickListener {
            val intent = Intent(this, Ingredientes::class.java)
            startActivity(intent)
        }
    }
}