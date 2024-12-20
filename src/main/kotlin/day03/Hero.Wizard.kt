package org.example.day03


class Wand(
    name: String,
    magicDamage: Double,
) {
    private var _magicDamage: Double = magicDamage
    private var _name: String = name

    val magicDamage: Double
        get() {
            println("$_magicDamage")
            require(_magicDamage in 0.5..100.0) { "must between 0.5 to 100.0" }
            return _magicDamage
        }
    val name: String
        get() {
            require(_name.length >= 3) { "Must your name larger than 3" }
            return _name
        }
}


class Wizard(
    override var name: String,
    hp: Int,
    var wand: Wand? = null,
    mp: Int = 10,
) : Hero(name, hp) {
    override var hp: Int = hp
        get() {
            if (field < 0) hp = 0
            return field
        }

    fun heal(hero: Hero) {
        hero.hp += 10
        println("${hero.name}의 hp를 10 회복했습니다")
    }
}

