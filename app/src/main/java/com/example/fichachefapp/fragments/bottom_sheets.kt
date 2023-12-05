package com.example.fichachefapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.fichachefapp.FichaTecnicaAlert
import com.example.fichachefapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class bottom_sheets : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bottom_sheets, container, false)

        // Configurar os cliques dos botões
        val layoutCriarFicha = view.findViewById<LinearLayout>(R.id.layoutCriarFicha)
        layoutCriarFicha.setOnClickListener {
            val intent = Intent(requireContext(), FichaTecnicaAlert::class.java)
            startActivity(intent)
        }

        val layoutShorts = view.findViewById<LinearLayout>(R.id.layoutAdicionarCusto)
        layoutShorts.setOnClickListener {
            val intent = Intent(requireContext(), FichaTecnicaAlert::class.java)
            startActivity(intent)
        }

        val cancelButton = view.findViewById<ImageView>(R.id.cancelButton)
        cancelButton.setOnClickListener {
            // Código para executar quando o botão de cancelar for clicado
            fragmentManager?.beginTransaction()?.remove(this@bottom_sheets)?.commit() // Fecha o BottomSheet
        }

        return view
    }
}