package org.example.day03

import org.example.domain.traits.GetDamageable

open class Slime(val suffix: String): GetDamageable {
    override var hp = 50

    open fun attack(hero: GetDamageable) {
        println("슬라임 ${suffix}가 공격했다.")
        println("10의 데미지")
        hero.hp -= 10
    }

    override fun getDamage(damage: Int) {
        hp -= damage
    }
}