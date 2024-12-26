package org.example.day07

import org.example.day06.Slime

abstract class Character(
    var name: String,
    var hp: Int,
) {
    fun run() = println("run")

    abstract fun attack(slime: Slime)
}

class Dancer(
    name: String,
    hp: Int
) : Character(name, hp) {
    override fun attack(slime: Slime) {
    }
}