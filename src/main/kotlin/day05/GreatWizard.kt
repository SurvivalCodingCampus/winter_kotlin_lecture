package day05

import day06.Hero

class GreatWizard(
    name: String,
    hp: Int,
    override var mp: Int = MAX_MP,
    wand: Wand
) : Wizard(hp = hp, name = name, wand = wand) {

    // 대상을 전부 회복
    private fun superHeal(hero: Hero) {
        if (mp < 50) {
            println(MANA_LACK)
        } else {
            hero.getHeal(Hero.MAX_HP)
            mp -= 50
            println("슈퍼 힐을 시전했습니다. 대상 HP: ${hero.hp}")
        }
    }

    companion object {
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