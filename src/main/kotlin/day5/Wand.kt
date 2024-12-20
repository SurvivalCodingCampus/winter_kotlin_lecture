package day5

import kotlin.properties.Delegates

class Wand(name: String, power: Double) {
    private lateinit var _name: String
    private var _power by Delegates.notNull<Double>()

    var name: String
        set(value) {
            require(value.length >= 3) { "이름의 최소길이는 3문자입니다." }
            _name = value
        }
        get() = _name
    var power: Double
        set(value) {
            require(value in 0.5..100.0) { "허용된 범위를 벗어난 값입니다." }
            _power = value
        }
        get() = _power

    init {
        this.name = name
        this.power = power
    }
}