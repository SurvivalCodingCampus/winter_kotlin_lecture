package org.example.day03

class Cleric(
    val name: String,  // 이름을 초기 설정 후 변경이 불가.
    var hp: Int = 50,
    var mp: Int = 10,
) {
    val MAX_HP = 50
    val MAX_MP = 10

    fun selfAid(): Unit {
        if (mp < 5) {
            return
        }

        mp -= 5
        hp = MAX_HP

    }

    fun pray(sec: Int): Int {
        if (sec <= 0) {
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