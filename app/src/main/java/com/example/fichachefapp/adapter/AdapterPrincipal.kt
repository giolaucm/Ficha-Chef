package com.example.fichachefapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.fichachefapp.ui.activity.CustoAdiciona
import com.example.fichachefapp.fragments.ListaFichaTecnica

internal class AdapterPrincipal(fa: FragmentActivity, var totalTabs: Int): FragmentStateAdapter(fa){

    private val tabTitles = listOf("Ficha Técnica", "Custo")

    override fun getItemCount(): Int {
        return totalTabs
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ListaFichaTecnica()
            1 -> CustoAdiciona()
            else -> throw IllegalArgumentException("Invalid position")
        }
    }

    fun getPageTitle(position: Int): CharSequence {
        return tabTitles[position]
    }
}