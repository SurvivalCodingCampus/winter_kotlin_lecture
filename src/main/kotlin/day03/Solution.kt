package org.example.day03

class Cleric(
    val name: String = "",  // 이름을 초기 설정 후 변경이 불가.
    var hp: Int = 50,
    var mp: Int = 10,
) {
    val MAX_HP = 50
    val MAX_MP = 10

    fun selfAid() : Unit {
        mp -= 5
        hp = MAX_HP
    }

    fun pray(sec : Int) : Int {
        if (sec <= 0)
            return -1

        var healMp = ( sec + (0..2).random() )

        if( (mp + healMp) > MAX_MP ) {
            healMp -= ( (mp + healMp) - MAX_MP )    // 실제로 회복한 mp량
            mp += healMp
            return healMp
        }
        else {
            mp += healMp
            return healMp
        }

    }

}