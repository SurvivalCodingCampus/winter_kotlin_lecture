package org.example.day06

open class Slime(
    hp: Int = DEFAULT_HP,
    private val suffix: String = "A"
) {
    val level = DEFAULT_LEVEL
    var damage = DEFAULT_DAMAGE
        private set

    var maxHp: Int = hp
        private set
    var hp: Int = hp
        private set

    open fun attack(hero: Hero) {
        println("슬라임 $suffix 가 공격했다")
        println("${damage}의 데미지")
        hero.reduceHp(damage)
    }

    companion object {
        const val DEFAULT_DAMAGE = 10
        const val DEFAULT_LEVEL = 3
        const val DEFAULT_HP = 20
    }
}