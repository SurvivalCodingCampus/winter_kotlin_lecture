package org.example.day8

import org.example.day3.Slime

abstract class Monster() {
    open fun run() = println("뚜벅 뚜벅")
}

fun main() {
    val slime = Slime("a")
    val monster: Monster = Slime("b")

    slime.run()
    monster.run()
}