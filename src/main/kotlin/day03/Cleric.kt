package day03

import kotlin.random.Random

fun main() {
    val cleric = Cleric(name = "최성자")

    cleric.selfAid()
    cleric.selfAid()
    cleric.selfAid()
    cleric.pray(2)
    cleric.pray(3)
    cleric.pray(3)
    cleric.pray(2)

}

class Cleric(var name: String, var hp: Int = 50, var mp: Int = 10) {
    private val maxHP = 50
    private val maxMP = 10

    fun selfAid() {
        if (mp >= 5) {
            mp -= 5
            hp = maxHP
            println("회복했습니다. 현재 HP: $hp | 현재 MP: $mp")
        } else {
            println("MP가 모자라 회복하지 못했습니다. 현재 HP: $hp | 현재 MP : $mp")
        }
    }

    fun pray(seconds: Int) : Int {
        val healingAmount = seconds + Random.nextInt(3)
        val actualRecover = if (mp + healingAmount > maxMP) {
            maxMP - mp
        } else {
            healingAmount
        }
        mp += actualRecover
        println("$seconds 초 동안 기도하여 $actualRecover MP 회복했습니다. 현재 HP: $hp | 현재 MP : $mp")

        return actualRecover
    }

}