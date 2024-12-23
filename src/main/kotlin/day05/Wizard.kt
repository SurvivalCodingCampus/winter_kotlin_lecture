package org.example.day05

object WizardErrorMsg {
    const val NAME_LENGTH_ERROR = "마법사의 이름은 3글자 이상이어야 합니다."
    const val MP_NEGATIVE_ERROR = "마법사의 MP는 0 이상 이어야 합니다."
}

class Wizard(
    name: String,
    hp: Int,
    mp: Int,
    var wand: Wand
) {
    var name: String = name
        set(value) {
            require(value.length >= 3) { WizardErrorMsg.NAME_LENGTH_ERROR }
            field = value
        }

    var hp: Int = hp
        set(value) {
            field = if (value < 0) 0 else value
        }

    var mp: Int = mp
        set(value) {
            require(value >= 0) { WizardErrorMsg.MP_NEGATIVE_ERROR }
            field = value
        }

    init {
        this.name = name
        this.hp = hp
        this.mp = mp
    }

    fun copy(
        name: String = this.name,
        hp: Int = this.hp,
        mp: Int = this.mp,
        wand: Wand = this.wand
    ): Wizard {
        return Wizard(name, hp, mp, wand)
    }
}