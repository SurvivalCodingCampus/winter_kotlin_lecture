package org.example.day04

import org.example.day03.Hero
import org.example.day05.Wand
import day08.Character

open class Wizard(
    name: String,
    hp: Int = MAX_HP,
    mp: Int = MAX_MP,
    var healAbility: Int = 0,
    _wand: Wand?,
): Character(name, hp, mp) {
    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 100
        const val MP_FOR_HEAL = 10
    }

    override fun attack(enemy: Enemy) {
        TODO("Not yet implemented")
    }

    override fun defend() {
        TODO("Not yet implemented")
    }

    override fun run() {
        TODO("Not yet implemented")
    }

    var wand: Wand? = if(_wand == null) throw IllegalArgumentException("wand는 null일 수 없습니다.") else _wand
        set(value) {
            if (value == null) {
                throw IllegalArgumentException("wand는 null일 수 없습니다.")
            }

            field = value
        }

    fun heal(hero: Hero) {
        if (mp < MP_FOR_HEAL) {
            println("mp가 부족합니다.")
            return
        }

        mp -= MP_FOR_HEAL
        hero.getHeal(healAbility)
        println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
    }
}