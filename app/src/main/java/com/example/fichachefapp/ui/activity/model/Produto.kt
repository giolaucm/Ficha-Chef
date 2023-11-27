import java.math.BigDecimal

data class Produto(
    val nome: String,
    val quantidade: BigDecimal,
    val unidadeMedida: String,
    val valorUnitario: BigDecimal,
    val margemLucro: BigDecimal,
    val desconto: BigDecimal
) {
    val precoBruto: BigDecimal
        get() = quantidade.multiply(valorUnitario)

    val precoLiquido: BigDecimal
        get() = precoBruto.subtract(precoBruto.multiply(desconto))

    val precoVenda: BigDecimal
        get() = precoBruto.multiply(margemLucro)

    companion object {
        fun custoTotal(produtos: List<Produto>): BigDecimal {
            return produtos.sumOf { it.precoBruto }
        }
    }
}
