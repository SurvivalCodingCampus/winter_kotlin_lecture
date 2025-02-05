package com.survivalcoding.com.survivalcoding.day08

import com.survivalcoding.com.survivalcoding.day03.Hero

fun main() {
    val names: List<String> = listOf("Seth", "Kathy", "Lars")
    val sortedNames = names.sorted()
    println(sortedNames)

    val h1 = Hero("홍길동", 300)
    val h2 = h1.copy()

    val heroes: List<Hero> = listOf(
        h1,
        Hero("강감찬", 100),
        Hero("이순시", 200),
    )

    val sortedHeroes = heroes.sorted()
//    val sortedHeroes = heroes.sortedByDescending { it.hp }
    println(sortedHeroes)


}