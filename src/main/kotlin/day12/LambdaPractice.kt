package org.example.day12

data class Trader(val name: String, val city: String)

data class Transaction(val trader: Trader, val year: Int, val value: Int)

fun main() {
    val transactions = listOf(
        Transaction(Trader("Brian", "Cambridge"), 2011, 300),
        Transaction(Trader("Raoul", "Cambridge"), 2012, 1000),
        Transaction(Trader("Raoul", "Cambridge"), 2011, 400),
        Transaction(Trader("Mario", "Milan"), 2012, 710),
        Transaction(Trader("Mario", "Milan"), 2012, 700),
        Transaction(Trader("Alan", "Cambridge"), 2012, 950),
    )

    // 1번
    transactions.filter { it.year == 2011 }.sortedBy { it.value }.forEach { println(it.trader.name) }

    // 2번
    transactions.distinctBy { it.trader.city }.forEach { println(it.trader.city) }

    // 3번
    transactions.filter { it.trader.city == "Cambridge" }.distinctBy { it.trader.name }.forEach { println(it.trader.name) }

    // 4번
    transactions.distinctBy { it.trader.name }.sortedBy { it.trader.name }.forEach { println(it.trader.name) }

    // 5번
    println(transactions.any { it.trader.city == "Milan" })

    // 6번
    transactions.filter { it.trader.city == "Cambridge" }.forEach { println(it.value) }

    // 7번
    println(transactions.sortedBy { -it.value }.first().value)

    // 8번
    println(transactions.sortedBy { it.value }.first().value)
}


