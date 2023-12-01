package com.example.fichachefapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.fichachefapp.ui.activity.Ingredientes
import com.google.android.material.button.MaterialButton

class FichaTecnicaAlert : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha_tecnica_alert)

        val btnProximo = findViewById<ImageButton>(R.id.btn_proximo)
        btnProximo.setOnClickListener {
            val intent = Intent(this, Ingredientes::class.java)
            startActivity(intent)
        }
    }
}