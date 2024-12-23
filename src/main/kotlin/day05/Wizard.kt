package day05

import day03.Hero

/*
마법사의 이름은 null 일 수 없고, 반드시 3문자 이상이어야 한다
마법사의 지팡이는 null 일 수 없다.
마법사의 MP는 0 이상이어야 한다.
HP가 음수가 되는 상황에서는 대신 0을 설정 되도록 한다. (에러 아님)

V.2.
속성:
mp: Int (초기값 100)
메서드:
heal(hero: Hero): Unit의 hp를 20 회복시키고 자신의 mp를 10 소모
mp가 부족하면 "마나가 부족합니다" 출력
힐을 성공하면 "힐을 시전했습니다. 대상 HP: ${hero.hp}" 출력

*/

open class Wizard(name: String, hp: Int, mp: Int = 100, var wand: Wand) {
    var name: String = name
        private set

    var mp: Int = mp
        protected set

    var hp: Int = hp
        private set

    init {
        require(name.length >= 3) { "마법사의 이름은 3문자 이상이어야 합니다" }
        require(mp >= 0) { "마법사의 MP는 0 이상이어야 합니다" }
        if (hp < 0) {
            this.hp = 0
        }
    }

    open fun heal(hero: Hero) {
        if (mp < 10) {
            println("마나가 부족합니다")
            return
        } else {
            mp -= 10
            hero.takeHp(20)
            println("힐을 시전했습니다. 대상 HP: ${hero.hp}")
        }

    }
}
