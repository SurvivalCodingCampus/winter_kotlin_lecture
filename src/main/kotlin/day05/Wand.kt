package org.hyunjung.day05

class Wand(
    name: String,
    power: Double
) {
    init {
        validateName(name)
        validatePower(power)
    }

    var name: String = name
        set(value) {
            validateName(value)
            field = value
        }

    var power: Double = power
        set(value) {
            validatePower(value)
            field = value
        }

    private fun validateName(value: String) {
        require(value.isNotBlank() && value.length >= 3) {
            "지팡이 이름은 null일 수 없고, 3문자 이상이어야 합니다."
        }
    }

    private fun validatePower(value: Double) {
        require(value in 0.5..100.0) {
            "지팡이의 마력은 0.5 이상 100.0 이하여야 합니다."
        }
    }
}