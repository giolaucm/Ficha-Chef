package com.example.fichachefapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.math.BigDecimal

class FichaFinal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ficha_final)

        // Receba os dados da outra atividade
        val custoTotal = intent.getSerializableExtra("custoTotal") as BigDecimal
        val custoPorUnidade = intent.getSerializableExtra("custoPorUnidade") as BigDecimal

        // Encontre os TextViews
        val custoTotalView = findViewById<TextView>(R.id.custoTotal)
        val custoPorUnidadeView = findViewById<TextView>(R.id.custoPorUnidade)

        // Defina os valores dos TextViews
        custoTotalView.text = custoTotal.toString()
        custoPorUnidadeView.text = custoPorUnidade.toString()
    }
}