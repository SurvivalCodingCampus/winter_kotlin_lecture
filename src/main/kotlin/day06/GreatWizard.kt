package day06

import org.example.day03.Hero
import org.example.day04.Wizard
import org.example.day05.Wand

class GreatWizard(
    name: String?,
    hp: Int = Wizard.MAX_HP,
    mp: Int = MAX_MP,
    healAbility: Int = 0,
    wand: Wand?,
) : Wizard(name, hp, mp, healAbility, wand){

    companion object {
        const val MAX_MP = 150
        const val MP_FOR_SUPERHEAL = 50
    }

    fun superHeal(hero: Hero): Unit {
        if(mp < MP_FOR_SUPERHEAL) {
            println("마나가 부족합니다.")
            return
        }
        mp -= 50
        hero.getHeal(Hero.MAX_HP)
        println("슈퍼 힐을 시전했습니다. 대상: ${hero.hp}")
    }
}