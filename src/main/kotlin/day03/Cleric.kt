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
}
