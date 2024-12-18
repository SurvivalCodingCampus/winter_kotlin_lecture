package org.example.day03

class Cleric(
    var name: String,
    var hp: Int = 50,
    var mp: Int = 10,
) {
    val maxHp = 50
    val maxMp = 10

    fun selfAid() {
        mp -= 5
        hp = maxHp
    }

    fun pray(prayTime: Int): Int {
        val recover = prayTime + (0..2).random()
        mp += recover
        if (mp > maxMp) {
            mp = maxMp
        }
        return recover
    }
}
