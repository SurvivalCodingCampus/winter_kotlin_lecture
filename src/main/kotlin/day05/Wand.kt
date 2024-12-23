package day05

class Wand(
    name: String,   // 이름
    power: Double,  // 마력
) {
    var name: String = name
        set(value) {
            require(value.length >= 3) { NAME_TOO_SHORT }
            field = value
        }


    var power: Double = power
        set(value) {
            require(value in (0.5..100.0)) { POWER_NOT_INCLUDE_IN_RANGE }
            field = value
        }

    companion object {
        const val NAME_TOO_SHORT = "이름이 너무 짧습니다."
        const val POWER_NOT_INCLUDE_IN_RANGE = "마력이 범위에 충족하지 않습니다."
    }
}

