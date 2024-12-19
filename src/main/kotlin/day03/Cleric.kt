package org.example.day03

class Cleric(
    val name: String,
    initHp: Int = 50,
    initMp: Int = 10,
) {
    var currentHp = initHp
    val maxHp = initHp
    var currentMp = initMp
    val maxMp = initMp

    fun pray(time: Int): Int {
        if (time <= 0) {
            return 0
        }
        var recoveryMp = time + (0..2).random()
        if (currentMp + recoveryMp > maxMp) {
            recoveryMp = maxMp - currentMp
            currentHp = maxHp
        } else {
            currentMp += recoveryMp
        }

        return recoveryMp
    }

    fun selfAid() {
        if (currentMp >= 5) {
            currentMp -= 5
            currentHp = maxHp
        }
    }
}