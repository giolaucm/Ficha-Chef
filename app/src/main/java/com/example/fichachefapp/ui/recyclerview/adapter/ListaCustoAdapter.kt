package com.example.fichachefapp.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fichachefapp.R
import com.example.fichachefapp.ui.activity.model.Custo

class ListaCustoAdapter(
    private val context: Context,
    custos: List<Custo>
): RecyclerView.Adapter<ListaCustoAdapter.ViewHolder>() {

    private val custos = custos.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun vincula(custo: Custo) {
            val nome = itemView.findViewById<TextView>(R.id.nome)
            nome.text = custo.Nome

            val custoValor = itemView.findViewById<TextView>(R.id.custo)
            custoValor.text = custo.Custo.toString()

            val tipoCusto = itemView.findViewById<TextView>(R.id.tipoDeCusto)
            tipoCusto.text = custo.TipoCusto
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.custo_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val custo = custos[position]
        holder.vincula(custo)
    }

    override fun getItemCount(): Int = custos.size
    fun atualiza(custos: List<Custo>) {
        this.custos.clear()
        this.custos.addAll(custos)
        notifyDataSetChanged()
    }

    fun getItem(position: Int): Custo {
        return custos[position]
    }
}