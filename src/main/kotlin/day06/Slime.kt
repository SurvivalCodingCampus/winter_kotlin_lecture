package day06

import org.example.day03.Hero
import kotlin.math.floor


open class Slime(val suffix: String) {
    companion object {
        const val SLIME_HP = 50
        const val SLIME_DAMAGE = 10
    }

    var hp = SLIME_HP

    open fun attack(hero: Hero) {
        if(hero.hp < SLIME_DAMAGE){
            hero.hp = 0
        }
        else {
            hero.hp -= SLIME_DAMAGE
        }
        println("슬라임 $suffix (이)가 공격했다.")
        println("${SLIME_DAMAGE} 의 데미지")
    }
}


class PoisonSlim(suffix: String) : Slime(suffix = suffix) {
    companion object {
        const val POISON_COUNT = 5
        val POISON_SLIME_DAMAGE = { heroHp: Double -> floor(heroHp / 5).toInt() }
    }

    private var poisonCount = POISON_COUNT

    override fun attack(hero: Hero) {
        super.attack(hero)
        if (poisonCount != 0) {
            println("추가로, 독 포자를 살포했다!")
            val poisonDamage = POISON_SLIME_DAMAGE(hero.hp.toDouble())

            hero.hp -= poisonDamage
            println("$poisonDamage 포인트의 데미지")
            poisonCount -= 1
        } else {
           println("더이상 독공격을 사용할 수 없습니다.")
        }
    }

}