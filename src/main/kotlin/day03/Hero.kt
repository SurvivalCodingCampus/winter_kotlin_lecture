package org.example.day03

fun main() {
    val hero = Hero(name = "홍길동", hp = 50)
    println(hero.hp)
    hero.sleep()
    println(hero.hp)

    val slime = Slime(100, "A")
    println(slime.suffix)
    println(slime.hp)
}

class Hero(
    var name: String,
    var hp: Int,
) {
    fun attack() {

    }

    fun run() {

    }

    fun sleep() {
        hp = 100
        println("${name}은 잠을 자고 회복했다 : $hp")
    }
}