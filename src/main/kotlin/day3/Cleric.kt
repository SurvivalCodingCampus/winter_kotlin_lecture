package org.example.day3

import kotlin.math.max

class Cleric(
    val name: String,
    var hp: Int = 50,
    val maxHp: Int = 200,
    var mp: Int = 25,
    val maxMp: Int = 100
) {
    fun selfAId() {
        mp -= 5
        hp = maxHp
    }
}