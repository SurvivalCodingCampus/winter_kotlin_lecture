package org.example.domain.behavior.skills

import org.example.day03.Hero

interface SuperHealable {
    fun superHeal(hero: Hero): Unit

    companion object {
        const val NEED_MP = 50
        const val SKILL_NAME = "슈퍼 힐"
    }
}