package day06

import org.example.day03.Slime
import org.example.day03.Hero

class PoisonSlime(
    name: String,
    var poisonCount: Int = 5,
): Slime(name) {
    override fun attack(hero: Hero) {
        super.attack(hero)
        if(poisonCount > 0) {
            println("추가로, 독 포자를 살포했다!")
            hero.hp -= (Hero.MAX_HP / 5)
            println("${Hero.MAX_HP / 5} 의 데미지")
            poisonCount--
        } else {
            println("독 포자 살포에 실패했다.")
        }
    }
}