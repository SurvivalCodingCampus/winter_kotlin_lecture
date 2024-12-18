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

}