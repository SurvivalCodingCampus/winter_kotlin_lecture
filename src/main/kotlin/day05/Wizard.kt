package org.hyunjung.day05

class Wizard(
    name: String,
    hp: Int,
    mp: Int = MAX_MP,
    wand: Wand?
) {
    companion object {
        const val MAX_MP = 10
    }

    init {
        validateName(name)
        validateMp(mp)
        validateWand(wand)
    }

    var name: String = name
        set(value) {
            validateName(value)
            field = value
        }

    var hp: Int = hp
        set(value) {
            validateMp(value)
            field = value
        }

    var mp: Int = mp
        set(value) {
            field = if (value < 0) {
                println("P는 음수일 수 없습니다. 대신 0으로 설정됩니다.")
                0
            } else value
        }

    var wand: Wand? = wand
        set(value) {
            validateWand(value)
            field = value
        }

    private fun validateName(value: String) {
        require(value.isNotBlank() && value.length >= 3) {
            "마법사의 이름은 null일 수 없고, 3문자 이상이어야 합니다."
        }
    }

    private fun validateMp(value: Int) {
        require(value >= 0) {
            "마법사의 MP는 0 이상이어야 합니다."
        }
    }

    private fun validateWand(value: Wand?) {
        require(value != null) {
            "마법사의 지팡이는 null일 수 없습니다."
        }
    }
}