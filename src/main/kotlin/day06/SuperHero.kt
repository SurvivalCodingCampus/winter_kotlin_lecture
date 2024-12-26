package org.example.day06

import org.example.day03.Hero
import org.example.day03.Slime

class SuperHero(
    name: String,
    hp: Int = 200,
) : Hero(name, hp) {

    init {
        // 생성자 이후에 실행 되는 코드
        println("SuperHero init block called")
    }

    override fun attack(slime: Slime) {
//        super.attack(slime)
        println("슈퍼 히어로가 공격했다.")
    }
}

fun main() {
    val superHero = SuperHero("man")
    val slime = Slime("A")
    superHero.attack(slime)
}