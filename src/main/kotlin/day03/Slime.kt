package org.hyunjung.day03

class Slime(hp: Int, private val suffix: String) {
    val level = 10

    fun run() {
        println("슬라임 ${suffix}가 도망갔다.")
    }
}