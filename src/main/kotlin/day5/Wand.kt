package org.example.day5

class Wand(
    name: String,
    var power: Double = 0.0,
) {
    var name: String = name
        set(value) {
//            if (3 > value.length) {
//                throw IllegalArgumentException("지팡이의 이름은 null 일 수 없고, 반드시 3문자 이상이어야 한다")
//            }
            require((3 <= value.length) && ("null" != value))  {
                throw IllegalArgumentException("지팡이의 이름은 null 일 수 없고, 반드시 3문자 이상이어야 한다")
            }
            field = value
        }

    init {
        this.name = name
    }
}