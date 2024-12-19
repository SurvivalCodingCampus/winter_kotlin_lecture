package org.example.day3

//const val MAX_HP = 50
//const val MAX_MP = 10

class Cleric(
    val name: String = "사제",
    var hp: Int = MAX_HP,
    var mp: Int = MAX_MP
) {
    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
    }


    fun selfAid() {
        if (mp >= 5) {
            mp -= 5
            hp = MAX_HP
        }
    }

    fun pray(prayTime: Int): Int {
        val number = (0..2).random()
        val startMp = mp

        if ((startMp == MAX_MP) || (prayTime <= 0)) return 0

        mp += (prayTime + number)

        if (mp > MAX_MP) mp = MAX_MP

        val recoveryMp = mp - startMp

        return recoveryMp
    }
}
