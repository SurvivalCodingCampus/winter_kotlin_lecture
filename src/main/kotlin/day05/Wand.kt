package org.example.day05

object WandErrorMsg {
    const val NANE_LENGTH_ERROR = "지팡이의 이름은 3글자 이상이어야 합니다"
    const val POWER_ERROR = "지팡이의 마력은 0.5 이상 100.0 이하여야 합니다."
}

class Wand(
    name: String,
    power: Double,
) {
    var name: String = name
        set(value) {
            require(value.length >= 3) { WandErrorMsg.NANE_LENGTH_ERROR }
            field = value
        }
    var power: Double = power
        set(value) {
            require(value in 0.5..100.0) { WandErrorMsg.POWER_ERROR }
            field = value
        }

    init {
        this.name = name
        this.power = power
    }

    fun copy(name: String = this.name, power: Double = this.power): Wand {
        return Wand(name, power)
    }
}