package day05

class Wand(
    var name: String,   // 이름
    power: Double,  // 마력
) {
    var power: Double = power
        set(value) {
            require(value in (0.5..100.0)) { "마력이 범위에 충족하지 않습니다." }
            field = value
        }
}

