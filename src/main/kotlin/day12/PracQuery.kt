data class Trader(val name: String, val city: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Trader

        return city == other.city
    }

    override fun hashCode(): Int {
        return city.hashCode()
    }
}

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

    // 1. 2011년에 일어난 모든 트랜잭션을 찾아 가격 기준 오름차순으로 정리하여 이름을 나열하시오
    transactions.filter { it.year == 2011 }.sortedBy { it.value }
        .forEach { println(it.trader.name) }

    println("1 -----end----------")
    // 2. 거래자가 근무하는 모든 도시를 중복 없이 나열하시오
    transactions.map { it.trader.city }.distinct().forEach { println(it) }


    // 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하여 나열하시오
    transactions.filter { it.trader.city == "Cambridge" }.sortedBy { it.trader.name }
        .forEach { println(it.trader.name) }


    // 4. 모든 거래자의 이름을 알파벳순으로 정렬하여 나열하시오
    transactions.sortedBy { it.trader.name }

    // 5. 밀라노에 거래자가 있는가?
    transactions.filter { it.trader.city == "Milan" }

    // 6. 케임브리지에 거주하는 거래자의 모든 트랙잭션값을 출력하시오
    transactions.filter { it.trader.city == "Cambridge" }
        .forEach { println("value of traders in Cambridge : ${it.value}") }

    // 7. 전체 트랜잭션 중 최대값은 얼마인가?
    val maxValue = transactions.reduce { acc, transaction -> if (acc.value > transaction.value) transaction else acc }
    println("MaxValue ${maxValue.value}")

    // 8. 전체 트랜잭션 중 최소값은 얼마인가?
    val minValue = transactions.reduce { acc, transaction -> if (acc.value < transaction.value) transaction else acc }
    println("MinValue ${minValue.value}")
}
