package org.example.day3

import org.example.day8.Monster

open class Slime(
    val suffix: String
): Monster() {
    var hp = 50

    open fun attack(hero: Hero): Unit{
        println("슬라임 $suffix 가 공격했다")
        println("10의 데미지")
        hero.hp -= 10
    }

    override fun run() = println("슬라임${suffix} 뚜벅 뚜벅")
}