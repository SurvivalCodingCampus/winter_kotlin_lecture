package org.example.day06

import org.example.day03.Hero
import org.example.day03.Slime

class PoisonSlime(  // 주석 처리한 이유 : Slime 클래스 인스턴스의 기본 조작 단원에서 open class에서 data class로 변경해서
    hp: Int,
    suffix: String,
) /*: Slime(hp,suffix) {
    companion object {
        const val ATTACK_CHANCE_COUNT = 5
    }

    var poisonCount: Int = ATTACK_CHANCE_COUNT
        private set

    var poisonDamage: Int = 0
        private set

    override fun attack(hero: Hero): Unit {
        super.attack(hero)
        if ((0 < poisonCount) && (0 < hero.hp)) {
            println("추가로, 독 포자를 살포했다!")

            poisonDamage = hero.hp/5
            if (0 < poisonDamage) {
                hero.hp -= poisonDamage
            } else {
                poisonDamage = 1
                hero.hp -= poisonDamage
            }

            println("${poisonDamage}포인트 데미지")

            poisonCount--
        }
    }
}

fun main() {
    val poisonSlime = PoisonSlime(10, "A")
    val hero = Hero("용사", hp = 100)
    poisonSlime.attack(hero)
}*/