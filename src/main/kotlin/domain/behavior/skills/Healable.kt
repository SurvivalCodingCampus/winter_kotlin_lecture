package org.example.domain.behavior.skills

import org.example.day03.Hero

interface Healable {
    var mp: Int

    fun heal(hero: Hero)

    companion object {
        const val NEED_MP = 10
        const val HEAL_AMOUNT = 20
        const val NEED_MORE_MP_MESSAGE = "마나가 부족합니다"

        fun afterHealMessage(hero: Hero) = "${hero.name}의 체력: ${hero.hp}"
    }
}