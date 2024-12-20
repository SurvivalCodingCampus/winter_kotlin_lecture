package org.example.day5

class Wand(
    name: String,
    power: Double = 0.5,
) {
    var name: String = name
        set(value) {
            require((3 <= value.length) && ("null" != value))  {
                throw IllegalArgumentException("지팡이의 이름은 null 일 수 없고, 반드시 3문자 이상이어야 한다")
            }
            field = value
        }
    var power: Double = power
        set(value) {
            require((0.5 <= value) && (100.0 >= value))  {
                throw IllegalArgumentException("지팡이의 이름은 null 일 수 없고, 반드시 3문자 이상이어야 한다")
            }
            field = value
        }

    init {
        this.name = name
        this.power = power
    }
}