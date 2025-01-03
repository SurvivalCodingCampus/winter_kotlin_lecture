package day12.exercise

/*
* 연습문제 - 쿼리
* */
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


    // 1. 2011년에 일어난 모든 트랜잭션을 찾아 가격 기준 오름차순으로 정리하여 이름을 나열하시오.
    val resultFirst = transactions.filter { list -> list.year == 2011 }.sortedBy { it.value }.map { it.trader.name }
    println(resultFirst)

    // 2. 거래자가 근무하는 모든 도시를 중복없이 나열하시오.
    val resultSecond = transactions.map { it.trader.city }.distinct()
    println(resultSecond)

    // 3. 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하여 나열하시오.
    val resultThird = transactions.filter { it.trader.city == "Cambridge" }.map { it.trader.name }.sorted().distinct()
    println(resultThird)
    // 4. 모든 거래자의 이름을 알파벳순으로 정렬하여 나열하시오
    val resultFourth = transactions.map { it.trader.name }.sorted().distinct()
    println(resultFourth)

    // 5. 밀라노에 거래자가 있는가?
    val resultSixth = transactions.any { it.trader.city == "Milan" }
    println(resultSixth)

    // 6. 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출력
    val resultSeventh = transactions.filter { it.trader.city == "Cambridge" }
    println(resultSeventh)

    // 7. 전체 트랙잭션 중 최대값은 얼마인가?
    val resultMax = transactions.maxOf { it.value }
    println(resultMax)

    // 8. 전체 트랜잭션 중 최소값은 얼마인가?
    val resultMin = transactions.minOf { it.value }
    println(resultMin)


}