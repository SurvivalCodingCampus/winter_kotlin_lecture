package org.example.day08

import org.example.day03.Slime

abstract class Monster() {
    open fun run() = println("뚜벅 뚜벅")
}

fun main() {
    val slime = Slime(100,"a")
    val monster: Monster = Slime(100,"b")

    slime.run()
    monster.run()
}