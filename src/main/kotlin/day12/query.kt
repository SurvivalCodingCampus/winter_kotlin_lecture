package day12

import kotlin.math.max
import kotlin.math.min

data class Trader(val name: String, val city: String)

data class Transaction(val trader: Trader, val year: Int, val value: Int)

fun main() {
    val transactions = listOf(
        Transaction(Trader("Brian", "Cambridge"), 2011, 300),
        Transaction(Trader("Raoul", "Cambridge"), 2012, 1000),
        Transaction(Trader("Raoul", "Cambridge"), 2011, 400),
        Transaction(Trader("Mario", "Milan"), 2012, 710),
        Transaction(Trader("Mario", "Milan"), 2012, 700),
        Transaction(Trader("Alan", "Cambridge"), 2012, 950)
    )


    transactions.filter { it.year == 2011 }.sortedWith(compareBy<Transaction> {it.value}).forEach { println(it.trader.name)}
    transactions.map { it.trader.city }.toSet().forEach { println(it.toString()) }
    transactions.filter { it.trader.city == "Cambridge" }.map { it.trader.name }.toSet().sortedWith(compareBy<String> {it.toString()}).forEach { println(it) }
    transactions.map { it.trader.name }.toSet().sortedWith(compareBy<String> { it }).forEach { println(it) }
    println("밀라노에 거래자가 있는가?: ${transactions.any { it.trader.city == "Milan" } }")
    transactions.filter { it.trader.city == "Cambridge" }.forEach { println(it.value) }
    println("전체 트랜젝션 중 최대값: ${transactions.map { it.value }.reduce(::max)}")
    println("전체 트랜젝션 중 최소값: ${transactions.map { it.value }.reduce(::min)}")

}
