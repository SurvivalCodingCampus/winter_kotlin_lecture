package org.example.day05

import org.example.day03.Hero
import org.example.domain.behavior.skills.Healable
import org.example.domain.error.InitializeError
import org.example.domain.types.error.WizardInitializeErrorType

open class Wizard(
    name: String,
    hp: Int,
    mp: Int,
    wand: Wand?,
): Healable {
    var name: String = name
        set(value) {
            require(value.length < 3) {
                throw InitializeError(WizardInitializeErrorType.SHORT_NAME)
            }
            field = value
        }

    override var mp: Int = mp
        set(value) {
            require(value >= 0) {
                throw InitializeError(WizardInitializeErrorType.INVALID_MP)
            }
            field = value
        }

    var hp: Int = hp
        set(value) {
            if(value < 0) {
                field = 0;
            }
            field = value
        }

    var wand: Wand? = wand
        set(value) {
            require(value == null) {
                throw InitializeError(WizardInitializeErrorType.NULL_WAND)
            }
            field = value
        }

    override fun heal(hero: Hero) {
        if(mp < Healable.NEED_MP) {
            println(Healable.NEED_MORE_MP_MESSAGE)
            return
        }
        hero.hp += Healable.HEAL_AMOUNT
        mp -= Healable.NEED_MP
        println(Healable.afterHealMessage(hero))
    }
}