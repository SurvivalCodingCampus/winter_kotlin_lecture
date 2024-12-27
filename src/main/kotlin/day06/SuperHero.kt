package org.example.day6

import org.example.day3.Hero

class SuperHero(
    name: String,
    hp: Int = 200,
) : Hero(name, hp) {

    init {
        // 생성자 이후에 호출 영역
        println("init 블럭이다")
    }

    override fun attack() {
        println("준비")
        super.attack()
        println("슈퍼히어로 attack")
    }
}

fun main() {
    val superHero = SuperHero("홍길동")
    superHero.attack()
}