package org.example.day06


object WandErrorMsg {
    const val POWER_ERROR = "지팡이의 마력은 0.5 이상 100.0 이하여야 합니다."
}

class Wand(
    name: String,
    power: Double,
) : Weapon(name) {
    var power: Double = power
        set(value) {
            require(value in MIN_POWER..MAX_POWER) {
                WandErrorMsg.POWER_ERROR
            }
            field = value
        }

    init {
        this.power = power
    }

    companion object {
        const val MIN_POWER = 0.5
        const val MAX_POWER = 100.0
    }
}