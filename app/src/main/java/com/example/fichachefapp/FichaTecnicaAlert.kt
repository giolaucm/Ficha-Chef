package com.example.fichachefapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import com.example.fichachefapp.ui.activity.Ingredientes

class FichaTecnicaAlert : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha_tecnica_alert)

        val btnClose= findViewById<ImageButton>(R.id.btn_close)
        btnClose.setOnClickListener {
            val intent = Intent(this, NomeReceita::class.java)
            startActivity(intent)
            finish()
        }

        val btnInicio= findViewById<Button>(R.id.btn_iniciar)
        btnInicio.setOnClickListener {
            val intent = Intent(this, NomeReceita::class.java)
            startActivity(intent)
            finish()
        }
    }
}