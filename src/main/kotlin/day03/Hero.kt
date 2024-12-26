package org.example.day03

import day06.Slime


abstract class Character(
    open var name: String,
    open var hp: Int,
) {
    open fun run() = println("$name 이 도망갔다.")

    abstract fun attack(slime: Slime)
}


class Sword(
    val name: String,
    val damage: Int,
) {

}

open class Hero(
    override var name: String,
    override var hp: Int = MAX_HP,
    open var sword: Sword? = null,
) : Character(name, hp) {

    companion object {
        const val MONEY = 1000
    }

    override fun run() {
        println("도망")
    }

    // 강제로 override 해야 컴파일이 진행된다.
    override fun attack(slime: Slime) {
        TODO("Not yet implemented")
    }

    fun sleep() {}
    fun usingSkills() {
    }
}


class SuperHero(name: String, hp: Int, sword: Sword? = null) : Hero(name, hp) {
    init {
        println("SuperHero")
    }

}