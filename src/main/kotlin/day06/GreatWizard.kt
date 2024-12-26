package org.example.day06

import org.example.day03.Hero
import org.example.day05.Wand
import org.example.day05.Wizard
import org.example.domain.behavior.skills.SkillMessageProvider
import org.example.domain.behavior.skills.SuperHealable

class GreatWizard(
    name: String,
    mp: Int = 150,
    hp: Int,
    wand: Wand?,
) : Wizard(name, hp, mp, wand), SuperHealable, SkillMessageProvider {
    override fun superHeal(hero: Hero) {
        if (mp < SuperHealable.NEED_MP) {
            println(getSkillNotEnoughMpMessage())
            return
        }

        hero.hp += Hero.MAX_HP
        mp -= SuperHealable.NEED_MP
        val effectMessage = "${hero.name}의 체력: ${hero.hp}"
        println(getSkillSuccessMessage(SuperHealable.SKILL_NAME, effectMessage))
    }
}