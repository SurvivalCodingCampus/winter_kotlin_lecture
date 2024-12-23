package org.example.day03


class Wand(
    name: String,
    magicDamage: Double,
) {
    private var _magicDamage: Double = magicDamage
    private var _name: String = name

    init {
        require(_magicDamage in 0.5..100.0) { "must between 0.5 to 100.0" }
        require(_name.length >= 3) { "Must your name larger than 3" }
    }

    val magicDamage: Double
        get() {
            require(_magicDamage in 0.5..100.0) { "must between 0.5 to 100.0" }
            return _magicDamage
        }
    val name: String
        get() {
            require(_name.length >= 3) { "Must your name larger than 3" }
            return _name
        }
}


open class Wizard(
    override var name: String,
    hp: Int,
    var wand: Wand? = null,
    mp: Int = WIZARD_MAX_MP,
) : Hero(name, hp) {
    var _mp = mp

    companion object {
        const val WIZARD_MAX_MP = 100
        const val USE_HEAL_MP = 10
    }

    override var hp: Int = hp
        get() {
            if (field < 0) hp = 0
            return field
        }

    fun heal(hero: Hero) {
        if (_mp < USE_HEAL_MP) println("마나가 부족합니다.")
        _mp -= USE_HEAL_MP
        hero.hp += 10
        println("힐을 시전했습니다. ${hero.name}의 hp를 10 회복했습니다")
    }
}

class GreatWizard(
    mp: Int = GREAT_WIZARD_MAX_MP,
    name: String,
    hp: Int = MAX_HP,
    wand: Wand?
) : Wizard(name, hp, wand, mp){

    companion object {
        const val GREAT_WIZARD_MAX_MP = 150
        const val USE_SUPER_HEAL_MP = 50
    }

    fun superHeal(hero: Hero) {
        if (_mp < USE_SUPER_HEAL_MP) println("마나가 부족합니다.")
        _mp -= USE_SUPER_HEAL_MP
        hero.hp = MAX_HP
        println("힐을 시전했습니다. ${hero.name}의 hp를 ${hero.hp} 회복했습니다")
    }

}

