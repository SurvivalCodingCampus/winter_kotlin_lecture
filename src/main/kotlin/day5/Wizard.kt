package org.example.day5

import java.lang.reflect.Array.set

class Wizard(
    name: String,
    hp: Int,
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

    var hp: Int = hp
        set(value) {
            // HP가 음수가 되는 상황에서는 대신 0을 설정 되도록 한다. (에러 아님)
            field = if (value < 0) 0 else value
        }

    var mp: Int = 0
        set(value) {
            require(0 <= value) {
                throw IllegalArgumentException("마법사의 MP는 0 이상이어야 한다")
            }
            field = value
        }

    val deadHp = 0

    init {
        this.name = name
        this.wand = wand
        this.hp = hp
    }

    fun attack() {

    }

    fun hurt(damage: Int) {
        hp -= damage
    }
}