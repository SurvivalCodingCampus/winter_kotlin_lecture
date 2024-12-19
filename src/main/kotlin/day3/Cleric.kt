package org.example.day3

class Cleric(
    val name: String,
    var hp: Int = 50,
    val maxHp: Int = 200,
    var mp: Int = 25,
    val maxMp: Int = 100
) {
    fun selfAid() {
        if (mp >= 5) {
            mp -= 5
            hp = maxHp
        }
    }

    fun pray(prayTime: Int): Int {
//        val numberRange = (0..2)
        val number = (0..2).random()
        val startMp = mp

        mp += (prayTime + number)

        if (mp > maxMp) mp = maxMp

        val recoveryMp = mp - startMp

        return recoveryMp
    }
}