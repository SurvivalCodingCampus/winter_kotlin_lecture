package day3

import day6.Actor
import day6.HealthPoint
import kotlin.math.floor
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

class Cleric(
    name: String,
    hp: Int = MAX_HP,
    var mp: Int = MAX_MP,
) : Actor(name, HealthPoint(hp, MAX_HP)) {
    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
    }

    fun attack() {
        TODO("Not yet implemented")
    }

    fun selfAid() {
        if (mp - 5 < 0) {
            return
        }

        require(hp.value > 0) { "체력이 0 이하인 상태에서는 치유할 수 없습니다" }
        hp.value = hp.maximum
        mp -= 5
    }

    fun pray(lengthInSeconds: Double): Int {
        if (lengthInSeconds == 0.0) {
            return 0
        } else if (lengthInSeconds < 0) {
            throw NegativeTimeException()
        }
        val compensation = Random.nextDouble(0.0, 2.0)
        val restoredMp = floor(lengthInSeconds + compensation).toInt()
        val overflow = max(0, restoredMp + mp - MAX_MP)

        mp = min(restoredMp + mp, MAX_MP)
        return restoredMp - overflow
    }

    class NegativeTimeException : Exception()
}