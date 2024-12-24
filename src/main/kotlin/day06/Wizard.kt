package org.example.day06

open class Wizard(
    name: String,
    mp: Int = DEFAULT_MP,
    wand: Wand,
) : Hero(name = name, mp = mp) {

    fun heal(hero: Hero) {
        if (mp < SKILL_HEAL_MP_COST) {
            println(MSG_NOT_ENOUGH_MP)
            return
        }
        reduceMp(10)
        hero.recoverHp(SKILL_HEAL_RECOVERY_POINTS)
        println(MSG_SUCCESS_HEAL)
        println("${hero.name}: ${hero.hp}")
    }

    init {
        this.weapon = wand
    }

    companion object {
        const val DEFAULT_MP = 100
        const val SKILL_HEAL_RECOVERY_POINTS = 20
        const val SKILL_HEAL_MP_COST = 10
        const val MSG_NOT_ENOUGH_MP = "마나가 부족합니다."
        const val MSG_SUCCESS_HEAL = "힐을 시전했습니다."
    }
}