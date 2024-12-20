package org.example.day5

class Wizard(
    name: String,
    var hp: Int,
    wand: Wand?,
) {
    var name: String = name
        set(value) {
            require((3 <= value.length) && ("null" != value))  {
                throw IllegalArgumentException("마법사의 이름은 null 일 수 없고, 반드시 3문자 이상이어야 한다")
            }
            field = value
        }
    var wand: Wand? = wand
        set(value) {
            require(wand != null) {
                throw IllegalArgumentException("마법사의 지팡이는 null 일 수 없다")
            }
            field = value
        }

    init {
        this.name = name
        this.wand = wand
    }


    fun attack() {


    }
}