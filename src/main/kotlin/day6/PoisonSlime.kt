package org.example.day6

import org.example.day3.Hero
import org.example.day3.Slime

class PoisonSlime(
    suffix: String,
) : Slime(suffix) {
    companion object {
        const val ATTACK_CHANCE_COUNT = 5
    }

    var poisonCoount: Int = ATTACK_CHANCE_COUNT
        private set

    var poisonDamage: Int = 0
        private set

    override fun attack(hero: Hero) {
        super.attack(hero)
        if ((0 < poisonCoount) && (0 < hero.hp)) {
            println("추가로, 독 포자를 살포했다!")

            poisonDamage = hero.hp/5
            if (0 < poisonDamage) {
                hero.hp -= poisonDamage
            } else {
                poisonDamage = 1
                hero.hp -= poisonDamage
            }

            println("${poisonDamage}포인트 데미지")

            poisonCoount--
        }
    }
}

fun main() {
    val poisonSlime = PoisonSlime("A")
    val hero = Hero("용사", hp = 100)
    poisonSlime.attack(hero)
}