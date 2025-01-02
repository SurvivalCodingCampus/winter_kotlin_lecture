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

    println('1')
    transactions.filter { it.year == 2011 }
        .sortedWith { a, b -> a.value - b.value }
        .forEach { println(it.trader) }
    println()

    println('2')
    transactions.map { it.trader.city }
        .distinct()
        .forEach(::println)
    println()

    println('3')
    transactions.filter { it.trader.city == "Cambridge" }
        .sortedWith { a, b -> a.trader.name.compareTo(b.trader.name) }
        .forEach(::println)
    println()

    println('4')
    transactions.map { it.trader.name }
        .sortedWith { a, b -> a.compareTo(b) }
        .forEach(::println)
    println()

    println('5')
    println(transactions.any { it.trader.city == "Milan" })
    println()

    println('6')
    transactions.filter { it.trader.city == "Cambridge" }
        .forEach(::println)
    println()

    println('7')
    println(transactions.map { it.value }
        .reduce { acc, v -> max(acc, v) })
    println()

    println('8')
    println(transactions.map { it.value }
        .reduce { acc, v -> min(acc, v) })
    println()
}
