package day6

import day3.Hero
import day5.Wizard

class GreatWizard(name: String) : Wizard(name, mp = 150.0) {
    fun superHeal(hero: Hero) {
        if (mp < 50) {
            println("마나가 부족합니다.")
            return
        }

        hero.hp.value = hero.hp.maximum
        this.mp -= 50
        println("슈퍼힐을 시전했습니다. 대상 HP상태: ${hero.hp.percent}%")
    }
}