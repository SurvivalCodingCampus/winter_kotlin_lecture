package org.hyunjung.day04

class Cleric(
    val name: String,
    var hp: Int = MAX_HP,
    var mp: Int = MAX_MP
) {
    companion object {
        const val MAX_HP: Int = 50
        const val MAX_MP: Int = 10
    }

    init {
        require(name.isNotBlank()) { "이름은 비어 있을 수 없습니다." }
        require(hp in 0..MAX_HP) { "HP는 0 이상 $MAX_HP 이하여야 합니다." }
        require(mp in 0..MAX_MP) { "MP는 0 이상 $MAX_MP 이하여야 합니다." }
    }
}