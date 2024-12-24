package org.example.day3

open class Slime(val suffix: String) {
    var hp = 50

    open fun attack(hero: Hero): Unit{
        println("슬라임 $suffix 가 공격했다")
        println("10의 데미지")
        hero.hp -= 10
    }
}