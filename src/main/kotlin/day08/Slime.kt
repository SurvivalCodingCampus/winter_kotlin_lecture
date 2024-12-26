package org.example.day08

import org.example.day06.Hero

class Slime(
    hp: Int
) : Monster(hp) {
    fun attack(hero: Hero, damage:Int = 10) {
        super.attack(hero)
        println("데미지")
    }
}

fun main(){
    val h1 = Hero("Df32")
    val s1 = Slime(100)
    s1.attack(h1)
}