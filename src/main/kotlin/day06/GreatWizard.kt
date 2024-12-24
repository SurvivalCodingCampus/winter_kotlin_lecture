package org.example.day06

class GreatWizard(
    name: String,
    mp: Int = DEFAULT_MP,
    wand: Wand,
) : Wizard(name, mp, wand) {

    fun superHeal(hero: Hero) {
        if (mp < SKILL_SUPER_HEAL_MP_COST) {
            println(MSG_NOT_ENOUGH_MP)
            return
        }
        hero.recoverHp(hero.maxHp)
        reduceMp(SKILL_SUPER_HEAL_MP_COST)
        println(MSG_SUCCESS_SKILL_SUPER_HEAL)
        println("${hero.name}: ${hero.hp}")
    }

    companion object {
        const val DEFAULT_MP = 150
        const val SKILL_SUPER_HEAL_MP_COST = 50
        const val MSG_SUCCESS_SKILL_SUPER_HEAL = "슈퍼 힐을 시전했습니다"
    }
}