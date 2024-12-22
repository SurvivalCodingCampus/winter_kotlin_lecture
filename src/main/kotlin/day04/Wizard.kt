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

    var name: String? = if(_name == null || _name.length < 3)
        throw IllegalArgumentException("이름은 null이거나 3보다 작을 수 없습니다.") else _name
        set(value) {
            if (value == null || value.length < 3) {
                throw IllegalArgumentException("이름은 null이거나 3보다 작을 수 없습니다.")
            }
            field = value
        }

    var wand: Wand? = if(_wand == null) throw IllegalArgumentException("wand는 null일 수 없습니다.") else _wand
        set(value) {
            if (value == null) {
                throw IllegalArgumentException("wand는 null일 수 없습니다.")
            }

            field = value
        }

    var mp = if(_mp < 0) throw IllegalArgumentException("mp가 음수입니다.") else _mp
        set(value) {
            if(value < 0) {
                throw IllegalArgumentException("mp가 음수입니다.")
            }
            field = value
        }

    var hp = if(_hp <= 0) 0 else _hp
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