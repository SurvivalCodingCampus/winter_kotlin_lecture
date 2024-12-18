package com.survivalcoding.day03

fun main() {
    val hero = Hero(name = "홍길동")
    println(hero.hp)
    hero.sleep()
    println(hero.hp)

    val slime = Slime(hp = 50, suffix = "A")
    println(slime.suffix)
    println(slime.hp)
}

class Hero(
    var name: String,
    var hp: Int = 100,
) { // 초기화
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