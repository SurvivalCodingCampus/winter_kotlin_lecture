package day05

class Wand(
    name: String,   // 이름
    power: Double,  // 마력
) {
    var name: String = name
        set(value) {
            require(value.length >= 3) { "이름이 너무 짧습니다." }
            field = value
        }


    var power: Double = power
        set(value) {
            require(value in (0.5..100.0)) { "마력이 범위에 충족하지 않습니다." }
            field = value
        }
}

