package org.example.day05

import org.example.day03.Hero

open class Wizard(
    name: String,
    hp: Int,
    wand: Wand?,
) {
    var name: String = name
        set(value) {
            require((3 <= value.length) && ("null" != value)) {
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

    open var mp: Int = 100
        set(value) {
            require(0 <= value) {
                throw IllegalArgumentException("마법사의 MP는 0 이상이어야 한다")
            }
            field = value
        }

    init {
        this.name = name
        this.wand = wand
        this.hp = hp
    }

    fun heal(hero: Hero): Unit {
        if (10 > mp) {
            println("마나가 부족합니다")
        } else {
            mp -= 10
            hero.hp += 20
            println("힐을 시전했습니다, 대상 HP: ${hero.hp}")
        }
    }

    fun attack(): Unit {

    }

    fun hurt(damage: Int): Unit {
        hp -= damage
    }
}