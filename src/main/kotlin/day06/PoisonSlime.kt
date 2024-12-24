package org.example.day06

import org.example.day03.Hero
import org.example.day03.Slime
import org.example.domain.traits.GetDamageable

class PoisonSlime(name: String): Slime(name) {
    var poisonCount: Int = 5
        private set

    override fun attack(hero: GetDamageable) {
        super.attack(hero)
        if(poisonCount > 0) {
            println(POISON_ATTACK_MESSAGE)
            val poisonDamage = (Hero.MAX_HP * POISON_DAMAGE_RATIO).toInt()
            println(hero.getDamageMessage(poisonDamage))
            hero.hp -= poisonDamage
            poisonCount--
        }
    }

    override fun getDamage(damage: Int) {
        hp -= damage
    }

    companion object {
        const val POISON_ATTACK_MESSAGE = "추가로, 독 포자를 살포 했다!"
        /// 최대 체력 대비 독 데미지 비율
        const val POISON_DAMAGE_RATIO = 0.2
    }

}