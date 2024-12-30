package day07

import day03.Slime

abstract class Character(
    open var name: String,
    open var hp: Int,
) {
    open fun run() {
        println("$name 이 도망갔다")
    }
    open fun attack(slime: Slime) {}
}

class Dancer(
    name: String,
    hp: Int
) : Character(name, hp) {   //다중상속 안됨
    override fun attack(slime: Slime) {
        super.attack(slime)
    }

}