package com.example.fichachefapp

import Produto
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.fichachefapp.dao.ProdutosDao
import java.math.BigDecimal

class Formulario : AppCompatActivity(R.layout.activity_formulario) {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraSalvar()
        configuraUnidadesMedida()
    }

    private fun configuraSalvar() {
        val btnAdicionar = findViewById<Button>(R.id.btn_adicionar)
        val dao = ProdutosDao()
        btnAdicionar.setOnClickListener {
            val produtoNovo = produto()
            dao.adiciona(produtoNovo)
            finish()
        }
    }

    private fun configuraUnidadesMedida() {
        val unidades = resources.getStringArray(R.array.unidades_medida)
        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, unidades)
        val editText = findViewById<AutoCompleteTextView>(R.id.unidMedBruto)
        editText.setAdapter(adapter)

        val campoQuantidade = findViewById<EditText>(R.id.precoBruto)
        campoQuantidade.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                val unidade = editText.text.toString()
                val valor = if (s.toString().isBlank()) 0.0 else s.toString().toDouble()
                val valorAjustado = when (unidade) {
                    "kg" -> valor * 1000
                    "g" -> valor
                    "ml" -> valor
                    else -> valor
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }
        })
    }

    private fun produto(): Produto {
        val campoNome = findViewById<EditText>(R.id.nome)
        val nome = campoNome.text.toString()

        val campoPrecoBruto = findViewById<EditText>(R.id.precoBruto)
        val precoBruto = BigDecimal(campoPrecoBruto.text.toString())

        val campoUnidadeMedida = findViewById<AutoCompleteTextView>(R.id.unidMedBruto)
        val unidadeMedida = campoUnidadeMedida.text.toString()

        val campoPrecoLiquido = findViewById<EditText>(R.id.qtdLiquido)
        val PrecoLiquido = BigDecimal(campoPrecoLiquido.text.toString())

        val margemLucro = BigDecimal.ZERO
        val desconto = BigDecimal.ZERO

        return Produto(
            nome = nome,
            PrecoBruto = precoBruto,
            unidMedida = unidadeMedida,
            PrecoLiquido = PrecoLiquido,
            margemLucro = margemLucro,
            desconto = desconto
        )
    }
}