package com.example.fichachefapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.math.BigDecimal

class FichaFinal : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_ficha_final, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Receba os dados da outra atividade
        val custoTotal = arguments?.getSerializable("custoTotal") as BigDecimal
        val custoPorUnidade = arguments?.getSerializable("custoPorUnidade") as BigDecimal

        // Encontre os TextViews
        val custoTotalView = view.findViewById<TextView>(R.id.custoTotal)
        val custoPorUnidadeView = view.findViewById<TextView>(R.id.custoPorUnidade)

        // Defina os valores dos TextViews
        custoTotalView.text = custoTotal.toString()
        custoPorUnidadeView.text = custoPorUnidade.toString()
    }
}