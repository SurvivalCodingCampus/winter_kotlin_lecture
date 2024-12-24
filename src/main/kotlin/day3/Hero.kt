package day3

import day6.Actor
import day6.HealthPoint

open class Hero(
    name: String,
    hp: Int = 100,
) : Actor(name, HealthPoint(hp)) {

    open fun attack() {
    }

    fun defend() {}

    fun flee() {}

    fun rest() {
        hp.value = hp.maximum
        println("${name}은 잠을 자고 회복했다: ${hp.value}")
    }
}

