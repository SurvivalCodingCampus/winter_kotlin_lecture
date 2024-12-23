package org.example.day06

import org.example.day05.Wand
import org.example.day05.Wizard

class GreatWizard(name: String, hp: Int, mp: Int = 150, wand: Wand) : Wizard(name, hp, mp, wand) {

    fun superHeal(hero: Hero) {
        if (mp < 50) {
            println("마나가 부족합니다")
            return
        }
        mp -= 50
        hero.hp = Hero.MAX_HP
        println("슈퍼 힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }
}