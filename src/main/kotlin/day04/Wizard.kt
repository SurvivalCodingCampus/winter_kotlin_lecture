package org.example.day04

import org.example.day03.Hero

class Wizard(
    var name: String,
    var hp: Int = MAX_HP,
    var mp: Int = MAX_MP,
    var healAbility: Int = 0,
) {
    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 30
        const val MP_FOR_HEAL = 5
    }

    fun heal(hero: Hero) {
        if(mp < MP_FOR_HEAL) {
            println("mp가 부족합니다.")
            return
        }

        hero.getHeal(healAbility)
    }
}