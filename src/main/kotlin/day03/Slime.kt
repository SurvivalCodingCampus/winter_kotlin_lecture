package org.example.day03

import org.example.day08.Monster

class Sword(val power: Double) {
}

data class Slime(
    var hp: Int = 50,
    val suffix: String,
    var sword: Sword? = null
): Monster() {
    val level = 10

    open fun attack(hero: Hero): Unit{
        println("슬라임 $suffix 가 공격했다")
        println("10의 데미지")
        hero.hp -= 10
    }

    override fun run() = println("슬라임${suffix} 뚜벅 뚜벅")
}

fun main() {
    val slime = Slime(hp = 100, suffix = "A")
    val slime2 = Slime(hp = 100, suffix = "A")
    println(slime === slime2)    //
    val (hp, suffix) = Slime(hp = 100, suffix = "A")
}