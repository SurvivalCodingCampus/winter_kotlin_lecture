package org.example.day03

import day08.Character
import org.example.day04.Enemy

class Cleric(
    name: String,  // 이름을 초기 설정 후 변경이 불가.
    hp: Int = MAX_HP,
    mp: Int = MAX_MP,
): Character(name, hp, mp) {
    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
    }

    override fun attack(enemy: Enemy) {
        TODO("Not yet implemented")
    }
    override fun defend() {
        TODO("Not yet implemented")
    }
    override fun run() {
        TODO("Not yet implemented")
    }

    fun selfAid(): Unit {
        if (mp < 5) {
            println("mp가 부족합니다.")
            return
        }

        mp -= 5
        hp = MAX_HP
    }

    fun pray(sec: Int): Int {
        if (sec <= 0) {
            println("0초 이하로 pray 할 수는 없습니다.")
            return 0
        }

        var healMp = (sec + (0..2).random())

        return if ((mp + healMp) > MAX_MP) {
            healMp -= ((mp + healMp) - MAX_MP)    // 실제로 회복한 mp량
            mp += healMp
            healMp
        } else {
            mp += healMp
            healMp
        }

    }

}