package com.example.fichachefapp.ui.activity

import Produto
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.fichachefapp.Formulario
import com.example.fichachefapp.Markup
import com.example.fichachefapp.NomeReceita
import com.example.fichachefapp.R
import com.example.fichachefapp.dao.ProdutosDao
import com.example.fichachefapp.databinding.ActivityIngredientesBinding
import com.example.fichachefapp.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Ingredientes : AppCompatActivity(R.layout.activity_ingredientes) {

    @SuppressLint("MissingInflatedId")
    private lateinit var binding: ActivityIngredientesBinding

    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIngredientesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configuraRecyclerView()
        configuraFab()

        val btnProximo= findViewById<Button>(R.id.btn_proximo)
        btnProximo.setOnClickListener {
            val intent = Intent(this, Markup::class.java)
            startActivity(intent)
        }

        val btnVoltar= findViewById<Button>(R.id.btn_voltar)
        btnVoltar.setOnClickListener {
            val intent = Intent(this, NomeReceita::class.java)
            startActivity(intent)
        }
    }


    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())

        val somaPrecoLiquido = dao.somaPrecoLiquido()
        val somaPrecoBruto = dao.somaPrecoBruto()

        // Agora você pode usar somaPrecoLiquido e somaPrecoBruto para atualizar sua tabela final
    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            vaiParaFormulario()
        }
    }

    private fun vaiParaFormulario() {
        val intent = Intent(this, Formulario::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter

        recyclerView.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                if (e.action == MotionEvent.ACTION_UP) {
                    val item = recyclerView.findChildViewUnder(e.x, e.y)
                    val position = recyclerView.getChildAdapterPosition(item!!)
                    val produto = adapter.getItem(position)
                    exibirAlerta(produto)
                }
                return false
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
        })
    }
    private fun exibirAlerta(produto: Produto) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Excluir item")
        builder.setMessage("Deseja excluir o item selecionado?")
        builder.setPositiveButton("Sim") { dialog, _ ->
            dao.removeProduto(produto)
            adapter.atualiza(dao.buscaTodos())
            dialog.dismiss()
        }
        builder.setNegativeButton("Não") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }
}