// CustoDao.kt
package com.example.fichachefapp.dao

import com.example.fichachefapp.ui.activity.model.Custo

class CustoDao {
    private val custos = mutableListOf<Custo>()

    @Synchronized
    fun adiciona(custo: Custo) {
        custos.add(custo)
    }

    @Synchronized
    fun buscaTodos(): List<Custo> {
        return custos.toList()
    }

    @Synchronized
    fun removeCusto(custo: Custo): Boolean {
        return custos.remove(custo)
    }

    @Synchronized
    fun limpaLista() {
        custos.clear()
    }
}