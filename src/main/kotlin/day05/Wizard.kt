package day05

import day03.Hero
import day06.Healable

/*마법사나 지팡이의 이름은 null 일 수 없고, 반드시 3문자 이상이어야 한다
지팡이의 마력은 0.5 이상 100.0 이하여야 한다.
마법사의 지팡이는 null 일 수 없다.
마법사의 MP는 0 이상이어야 한다.
HP가 음수가 되는 상황에서는 대신 0을 설정 되도록 한다. (에러 아님)
*/
/*속성:
mp: Int (초기값 100)
메서드:
heal(hero: Hero): Unit의 hp를 20 회복시키고 자신의 mp를 10 소모
mp가 부족하면 "마나가 부족합니다" 출력
힐을 성공하면 "힐을 시전했습니다. 대상 HP: ${hero.hp}" 출력
*/

open class Wizard(
    name: String,
    hp: Int,    //val, var없으면 getter, setter 안 생김
    mp: Int = 100,
    wand: Wand,
) : Hero(name, hp), Healable {
    init {
        validateName(name)
        require(mp >= 0) { "마법사의 mp는 0 이상이어야 한다" }
    }

    companion object {
        private val NAME_LENGTH = 3

        private fun validateName(name: String) {
            require(name.length >= NAME_LENGTH) { "마법사의 이름은 $NAME_LENGTH 문자 이상이어야 한다" }
        }
    }

    override var name: String = name
        set(value) {
            validateName(value)
            field = value                       //field는 getter, setter에서만 사용할 수 있는 내부 저장소로 속성 값 저장.
        }

    override var hp: Int = if (hp < 0) 0 else hp
    // 파라미터의 hp랑 다른거임!

    var mp: Int = mp

    override fun heal(hero: Hero): Unit {

        if (mp < 10) {
            println("마나가 부족합니다 $mp")
        } else {
            println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
            hero.hp += 20
            mp -= 10
            println("남은 마나 $mp")
        }
    }
}

fun main() {
    val wand = Wand(name = "지팡이", power = 80.0)
//    val wizard = Wizard(initialName = "간달프", initialHp = -10, mp = 30, wand = wand)
    val wizard = Wizard(name = "간달프", hp = 60, mp = 30, wand = wand)
    val hero = Hero("다덤벼", hp = 50)

//    println(wizard.initialHp)
//    println(wizard.hp)

    for (i in 1..4) {
        wizard.heal(hero)
        println("힐 이후 HP: ${hero.hp}")
    }
}