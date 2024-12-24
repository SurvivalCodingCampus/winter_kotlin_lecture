package org.example.day7

import org.example.day3.Slime

fun main() {
//    val character = Character("", 10)
}

//abstract class Runnable {
//    abstract  fun run()
//    abstract  fun stop()
//}

interface Runnable {
    // 프로퍼티도 가능 getter, setter 가 자동으로 생성되서
    val weight: Double

    fun run()
    fun stop()
}

abstract class Character(
    var name: String,
    var hp: Int,
) : Runnable {

    override fun run() {
        println("run")
    }

    abstract fun attack(slime: Slime)
}

class Dancer(
    name: String,
    hp: Int,
) : Character(name, hp) {
    override fun attack(slime: Slime) {
        TODO("Not yet implemented")
    }

    override val weight: Double
        get() = TODO("Not yet implemented")

    override fun stop() {
        TODO("Not yet implemented")
    }


}