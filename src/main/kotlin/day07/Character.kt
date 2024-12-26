package com.survivalcoding.day07

import com.survivalcoding.day03.Slime


//abstract class Runnable {
//    abstract fun run()
//    abstract fun stop()
//}

interface Runnable {
    var weight: Double

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
    hp: Int
) : Character(name, hp) {

    override fun attack(slime: Slime) {
        TODO("Not yet implemented")
    }

    override var weight: Double
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun stop() {
        TODO("Not yet implemented")
    }

}