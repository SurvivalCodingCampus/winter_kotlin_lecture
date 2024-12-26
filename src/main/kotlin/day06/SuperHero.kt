package day06

import day03.Hero
import day03.Slime

class SuperHero(
    name: String,
    hp: Int,
//    var sword: Sword? = null,
) : Hero(name, hp) {
    var isFlying: Boolean = false

        set(value) {
            field = value
            if (value) {
                println("$name 이 날개를 펼쳤다")
            } else {
                println("$name 이 날개를 접었다")
            }
        }

    override fun attack(slime: Slime) {
        super.attack(slime)

        if (isFlying) {
            println("$name 이 $slime 을 공격했다")
            slime.hp -= 5
            println("5포인트의 추가 피해를 입혔다")
        }
//        slime.hp -= sword?.dameage ?: 5
    }

    override fun run() {
        println("$name 이 퇴각했다")
    }
}

interface Attackable {
    fun attack(target: Slime)
    fun defend()
}

interface Healable {
    fun heal(target: Hero)
}

fun main() {
    val hero = Hero(name = "홍길동", hp = 100)
    hero.run()

    val superHero = SuperHero(name = "한석봉", hp = 50)
    superHero.run()
}