package org.example.day04

import org.example.day03.Hero

class Wizard(
    var name: String,
    var hp: Int,
    var healAbility: Int = 0,
) {
    fun heal(hero: Hero) {
        hero.getHeal(healAbility)
    }
}