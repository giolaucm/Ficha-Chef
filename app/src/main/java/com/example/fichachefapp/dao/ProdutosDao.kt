package com.example.fichachefapp.dao

import Produto
import java.math.BigDecimal

class ProdutosDao {

    @Synchronized
    fun adiciona(produto: Produto) {
        produtos.add(produto)
    }

    @Synchronized
    fun buscaTodos(): List<Produto> {
        return produtos.toList()
    }

    @Synchronized
    fun removeProduto(produto: Produto): Boolean {
        return produtos.remove(produto)
    }

    @Synchronized
    fun limpaLista() {
        produtos.clear()
    }

    fun somaPrecoLiquido(): BigDecimal {
        return BigDecimal(produtos.sumByDouble { it.precoLiquido.toDouble() })
    }

    fun somaPrecoBruto(): BigDecimal {
        return BigDecimal(produtos.sumByDouble { it.PrecoBruto.toDouble() })
    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }
}