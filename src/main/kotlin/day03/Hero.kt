package org.example.day03

fun main() {
    val hero = Hero(name = "홍길동", hp = 50)
    println(hero.hp)
    hero.sleep()
    println(hero.hp)

    val slime = Slime(100, "A")
    println(slime.suffix)
    println(slime.hp)

    val gildong = mapOf(
        "name" to "홍길동",
        0 to 0,
    )
}

class Hero(
    name: String,
    hp: Int = 100,
) {
    var hp: Int = hp
        private set

    var name: String = name
        set(value) {
            if (value.length <= 1) {
                throw IllegalArgumentException("이름이 너무 짧습니다")
            }
            if (value.length >= 8) {
                throw IllegalArgumentException("이름이 너무 깁니다")
            }
            field = value
        }

//    require 사용
//    var name: String = name
//        set(value) {
//            require(value.length > 1) { "이름이 너무 짧습니다" }
//            require(value.length < 8) { "이름이 너무 깁니다" }
//            field = value
//        }

    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
    }

    fun attack() {

    }

    fun run() {

    }

    fun bye() {

    }

    fun die() {

    }

    fun sleep() {
        hp = 100
        println("${name}은 잠을 자고 회복했다 : $hp")
    }
}