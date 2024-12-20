package org.example.day04

class Enemy(
    val name: String,
    var hp: Int = MAX_HP,
) {
    companion object {
        const val MAX_HP = 20
    }

    fun attacked(damage: Int) {
        hp = if (damage > hp) {
            println("$name 처치")
            0
        } else {
            val updateHp = hp - damage
            updateHp
        }
    }
}