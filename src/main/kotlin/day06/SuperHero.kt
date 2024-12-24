package org.example.day06


class SuperHero(
    name: String,
    hp: Int = DEFAULT_HP,
    mp: Int = DEFAULT_MP,
    sword: Sword = Sword("기본검")
) : Hero(name, hp, mp) {

    init {
        this.weapon = sword
    }

    override fun attack() {
        println("준비")
        super.attack()
        println("super hero attack")
    }

    companion object {
        const val DEFAULT_MAX_HP = 100
        const val DEFAULT_MAX_MP = 100
        const val DEFAULT_HP = DEFAULT_MAX_HP
        const val DEFAULT_MP = DEFAULT_MAX_MP
    }
}