package org.example.day03

open class Slime(val suffix: String) {
    var hp = 50

    fun run() {
        println("슬라임 ${suffix}가 도망갔다.")
    }

    open fun attack(hero: Hero) {
        println("슬라임 $suffix 가 공격했다.")
        println("10의 데미지")
        hero.hp -= 10
    }
}