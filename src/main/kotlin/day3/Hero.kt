package day3

import day6.Actor

open class Hero(
    name: String,
    hp: Int = 100,
    protected var maxHp: Int = hp
) : Actor(name) {
    var hp = hp
        private set

    open fun attack() {

    }

    fun defend() {}

    fun flee() {}

    fun rest() {
        hp = maxHp
        println("${name}은 잠을 자고 회복했다: $hp")
    }
}

