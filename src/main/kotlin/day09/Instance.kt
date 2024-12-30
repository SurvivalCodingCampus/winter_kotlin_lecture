package day09

import day03.Hero
import java.util.Objects

fun main() {
    val heroes = mutableSetOf<Hero>()
    val h1 = Hero("슈퍼맨", 100)
    val h2 = Hero("슈퍼", 100)
    println(h1 == h2)


}

