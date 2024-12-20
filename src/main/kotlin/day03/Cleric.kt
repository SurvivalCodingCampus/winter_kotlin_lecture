package org.hyunjung.day03

class Cleric(
    val name: String,
    var hp: Int = MAX_HP,
    var mp: Int = MAX_MP
) {
    companion object {
        const val MAX_HP: Int = 50
        const val MAX_MP: Int = 10
        const val MAX_PRAY_TIME: Int = 10
    }

    fun selfAid() {
        if (mp < 5) return

        mp -= 5
        hp = MAX_HP
    }

    fun pray(time: Int): Int {
        require(time > 0) { "기도 시간은 1초 이상이어야 합니다." }

        if (mp >= MAX_MP) return 0

        val prayTime = time.coerceAtMost(MAX_PRAY_TIME)

        val recoveryAmount = prayTime + (0..2).random()
        val actualRecovery = (mp + recoveryAmount).coerceAtMost(MAX_MP) - mp
        mp += actualRecovery

        return actualRecovery
    }
}