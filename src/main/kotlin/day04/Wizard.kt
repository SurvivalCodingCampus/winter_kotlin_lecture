package org.example.day04

import org.example.day03.Hero
import org.example.day05.Wand

class Wizard(
    _name: String?,
    _hp: Int = MAX_HP,
    _mp: Int = MAX_MP,
    var healAbility: Int = 0,
    _wand: Wand?,
) {
    init {

    }
    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 30
        const val MP_FOR_HEAL = 5
    }

    var name: String? = if(_name == null || _name.length < 3) throw IllegalArgumentException() else _name
        set(value) {
            if (value == null || value.length < 3) {
                throw IllegalArgumentException()
            }
            field = value
        }

    var wand = _wand
        set(value) {
            if (value == null) {
                throw IllegalArgumentException()
            }

            field = value
        }

    var mp = _mp
        set(value) {
            if(value < 0) {
                throw IllegalArgumentException()
            }
            field = value
        }

    var hp = _hp
        set(value) {
            field = if(value < 0) 0 else value
        }

    fun heal(hero: Hero) {
        if (mp < MP_FOR_HEAL) {
            println("mp가 부족합니다.")
            return
        }

        hero.getHeal(healAbility)
    }
}