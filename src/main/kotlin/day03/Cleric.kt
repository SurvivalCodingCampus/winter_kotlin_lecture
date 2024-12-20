package org.example.day03

class Cleric(
    var name: String,
    var hp: Int = MAX_HP,
    var mp: Int = MAX_MP,
) {
    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
        const val MP_COST_OF_SELF_AID = 5
    }

    fun pray(sec: Int): Int {
        if (sec <= 0) {
            return 0
        }

        var recoveryMp = sec + (0..2).random()

        if (mp + recoveryMp > MAX_MP) {
            recoveryMp = MAX_MP - mp
            hp = MAX_HP
        } else {
            mp += recoveryMp
        }

        return recoveryMp
    }

    fun selfAid() {
        if (mp >= MP_COST_OF_SELF_AID) {
            mp -= MP_COST_OF_SELF_AID
            hp = MAX_HP
        }
    }
}