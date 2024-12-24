package day07

import day06.Slime

abstract class Character(
    var name: String,
    var hp: Int,
) {
    fun run() = println("$name 이 도망갔다")


    // 추상 메서드
    abstract fun attack(slime: Slime)
}

class Runner() : Runnable {
    override fun run() {
        TODO("Not yet implemented")
    }

}

interface Runnable {
    fun run()
}