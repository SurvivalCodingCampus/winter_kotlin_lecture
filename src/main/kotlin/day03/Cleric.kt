package org.example.day03


class Cleric(
    val name: String,  // 이름을 초기 설정 후 변경이 불가.
    var hp: Int = MAX_HP,
    var mp: Int = MAX_MP,
) {
    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
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