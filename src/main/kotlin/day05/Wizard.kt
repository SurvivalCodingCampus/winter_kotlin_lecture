package day05

import day06.Hero


/*
* 작성한 Wand 클래스와 Wizard 클래스에 대해 4가지 규칙 타당성 검사 진행
*
* 부정한 값이 설정될 경우에는 "IllegalArgumentException" 작성
*
* 1. 마법사나 지팡이의 이름은 null일 수 없고, 반드시 3문자 이상이어야 한다. -> (o)
* 2. 지팡이의 마력은 0.5 이상 100.0 이하여야 한다. -> ()
* 3. 마법사의 지팡이는 null 일 수 없다.
* 4. 마법사의 MP는 0 이상이어야 한다.
* 5. HP가 음수가 되는 상황에서는 대신 0을 설정되도록 한다.
*
* */

open class Wizard(
    name: String,       // 이름
    hp: Int,            // hp
    mp: Int = MAX_MP,            // mp
    var wand: Wand         // Wand(완드)
) {
    var name: String = name
        set(value) {
            require(value.length >= 3) { NAME_TOO_SHORT }
            field = value
        }

    open var mp: Int = mp
        set(value) {
            require(value >= 0) { MP_LACK }
            field = value
        }

    var hp: Int = hp
        set(value) {
            field = if (value < 0) 0 else value
        }


    // 회복 기능 메소드
    private fun heal(hero: Hero) {
        if (mp < 10) {
            println(MANA_LACK)
        } else {
            hero.getHeal(20)
            mp -= 10
            println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
        }
    }

    companion object {
        const val MAX_MP = 100
        const val NAME_TOO_SHORT = "이름이 너무 짧습니다."
        const val MP_LACK = "mp가 부족합니다."
        const val MANA_LACK = "마나가 부족합니다."
    }
}