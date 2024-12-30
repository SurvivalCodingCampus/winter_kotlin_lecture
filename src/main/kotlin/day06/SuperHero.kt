package day06

import org.example.day03.Hero
import org.example.day04.Enemy
import org.example.day04.Sword

class SuperHero(
    name: String,
    hp: Int,
    mp: Int,
    sword: Sword? = null,
): Hero(name, hp, mp, sword) {
    var isFlying: Boolean = false
        set(value) {
            field = value
            if(value) {
                println("$name 이 날개를 펼쳤다.")
            } else {
                println("$name 이 날개를 접었다.")
            }
        }
    override fun run() {
        println("$name 이 도망쳤다.")
    }

    override fun attack(enemy: Enemy) {
        super.attack(enemy)
        if(isFlying) {
            println("$name 이 ${enemy.name} 를 공격했다.")
            enemy.hp -= 5
            println("5포인트의 추가 피해를 입혔다.")
        }
    }
}