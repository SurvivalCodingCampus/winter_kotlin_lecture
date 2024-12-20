package org.example.day03

import kotlin.math.min

const val MAX_HP = 50
const val MAX_MP = 10
const val USE_MP_SELF_AID = 5

class Cleric(
    val name: String,
    var hp: Int = MAX_HP,
    var mp: Int = MAX_MP,
) {

    fun selfAid() {
        if (hp <= 0) return
        if (mp >= USE_MP_SELF_AID) {
            hp = MAX_HP
            mp -= USE_MP_SELF_AID
        }
    }

    fun pray(seconds: Int): Int {
        if (mp >= MAX_MP || mp < 0 || seconds < 0) return 0

        val currentMp = mp
        val random = (0..2).random()

        mp = min(currentMp + seconds + random, MAX_MP)

        return mp - currentMp
    }
}

