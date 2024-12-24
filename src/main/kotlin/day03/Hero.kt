package org.example.day03

class Sword(
    val name: String,
    val damage: Int,
) {

}

open class Hero(
    open val name: String,
    open var hp: Int = MAX_HP,
    open var sword: Sword? = null,
) {

    companion object {
        const val MONEY = 1000
    }

    fun run() {}
    fun sleep() {}
    fun usingSkills() {
    }
}


class SuperHero(name: String, hp: Int, sword: Sword? = null) : Hero(name, hp) {
    init {
        println("SuperHero")
    }

}