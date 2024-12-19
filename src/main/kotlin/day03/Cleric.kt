package org.example.day03

import kotlin.math.min

const val MAX_HP = 50
const val MAX_MP = 10

class Cleric(
    val name: String,
    var hp: Int = MAX_HP,
    var mp: Int = MAX_MP,
) {
    fun selfAid() {
        if (mp < 5) {
            return
        }

        mp -= 5
        hp = MAX_HP
    }

    fun pray(sec: Int): Int {
        if (sec < 1) {
            return 0
        }

        if (mp == MAX_MP) {
            return 0
        }

        val randomNumber = (0..2).random()

        val currentMp = mp

        mp += min(sec + randomNumber, MAX_MP)

        return mp - currentMp
    }
}

