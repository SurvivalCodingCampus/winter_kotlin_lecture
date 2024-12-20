package com.survivalcoding.day03

import kotlin.random.Random

fun main() {
    val hero = Hero(name = "홍길동")
    println(hero.hp)
    hero.sleep()
    println(hero.hp)

    val slime = Slime(hp = 50, suffix = "A")
    println(slime.suffix)
    println(slime.hp)


}

const val HERO_MONEY = 100

class Hero(
    name: String,
    hp: Int = 100,
) { // 초기화

    var hp: Int = hp
        private set

    var name: String = name
        set(value) {
            require(value.isNotEmpty()) { "이름이 짧다" }
            field = value
        }


//    private var _hp = hp


//        get() = _hp

    // Java의 static
    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10

        var MONEY = 100

        fun setRandomMoney() {
            val hero = Hero("홍길동")
            println(hero.name)

            MONEY = Random.nextInt(1000)
        }
    }


    var food = ""

    // 메소드
    fun attack() {

    }

    fun run() {

    }

    fun sleep() {
        hp = 100
        println("${name}은 잠을 자고 회복했다 : $hp")
    }

    fun pung(): String {
        // 먹은 게(food) 있으면 뿡
        // 없으면 뽕
        return "뽕"
    }
}