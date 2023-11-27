import java.math.BigDecimal

data class Produto(
    val nome: String,
    val PrecoBruto: BigDecimal,
    val unidMedida: String,
    val valorUnitario: BigDecimal,
    val margemLucro: BigDecimal,
    val desconto: BigDecimal
) {
    val precoLiquido: BigDecimal
        get() = PrecoBruto.subtract(PrecoBruto.multiply(desconto))

    val precoVenda: BigDecimal
        get() = PrecoBruto.multiply(margemLucro)

    companion object {
        fun custoTotal(produtos: List<Produto>): BigDecimal {
            return produtos.sumOf { it.PrecoBruto }
        }
    }
}