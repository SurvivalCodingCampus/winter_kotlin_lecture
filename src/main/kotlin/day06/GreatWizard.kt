package day06

import day05.Wand
import day05.Wizard

class GreatWizard(
    name: String,
    hp: Int,
    override var mp: Int = MAX_MP,
    wand: Wand
) : Wizard(hp = hp, name = name, wand = wand) {

    // 대상을 전부 회복
    fun superHeal(hero: Hero) {
        if (mp >= MP_FOR_USE_SKILL) {
            hero.getHeal(Hero.MAX_HP)
            mp -= MP_FOR_USE_SKILL
            println("슈퍼 힐을 시전했습니다. 대상 HP: ${hero.hp}")
        } else {
            println(MANA_LACK)
        }
    }

    companion object {
        const val MP_FOR_USE_SKILL = 50
        const val MAX_MP = 150
        const val MANA_LACK = "마나가 부족합니다."
    }
}

fun main() {
    val greatWizard = GreatWizard(name = "간달프", hp = 100, wand = Wand(name = "우드완드", power = 40.0))
    println(greatWizard.mp)
    println(greatWizard.name)
    println(greatWizard.hp)
    println(greatWizard.wand)
}