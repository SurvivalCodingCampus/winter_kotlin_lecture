package org.example.day08

import org.example.day06.Hero

abstract class Monster(
    hp:Int,
) {
    open fun attack(hero: Hero){
        println("${hero.name} 공격")
    }
}