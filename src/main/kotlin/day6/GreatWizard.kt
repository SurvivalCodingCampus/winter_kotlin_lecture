package org.example.day6

import org.example.day3.Hero
import org.example.day5.Wand
import org.example.day5.Wizard

class GreatWizard(
    name: String,
    hp: Int,
    wand: Wand?
): Wizard(name, hp, wand) {
    override var mp = 150

    fun superHeal(hero: Hero) {
        if (50 > mp) {
            println("마나가 부족합니다")
        } else {
            mp -= 50
            hero.hp = Hero.MAX_HP
            println("슈퍼힐을 시전했습니다, 대상 HP: ${hero.hp}")
        }
    }
}