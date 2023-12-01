import java.math.BigDecimal

data class Produto(
    val nome: String,
    val PrecoBruto: BigDecimal,
    val unidMedida: String,
    val PrecoLiquido: BigDecimal,
    val margemLucro: BigDecimal,
    val desconto: BigDecimal
) {
    val precoVenda: BigDecimal
        get() = PrecoBruto.multiply(margemLucro)

    companion object {
        fun custoTotal(produtos: List<Produto>): BigDecimal {
            return produtos.sumOf { it.PrecoBruto }
        }
    }
}