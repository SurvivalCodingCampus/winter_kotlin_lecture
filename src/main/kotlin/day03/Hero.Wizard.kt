package org.example.day03


class Wizard(
    override var name: String,
    override var hp: Int = 50,
    var mp: Int = 10,
) : Hero(name, hp) {

    fun heal(hero: Hero) {
        hero.hp += 10
        println("${hero.name}의 hp를 10 회복했습니다")
    }
}

