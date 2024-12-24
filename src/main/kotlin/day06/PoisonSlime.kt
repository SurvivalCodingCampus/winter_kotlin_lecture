package org.example.day06

class PoisonSlime(
) : Slime() {

    var poisonCount: Int = DEFAULT_POISON_COUNT
        private set

    override fun attack(hero: Hero) {
        super.attack(hero)

        if (poisonCount > 0) {
            println(MSG_POISON_ATTACK)
            hero.reduceHp(hero.maxHp / POISON_DAMAGE_RATIO_OF_MAX_HP)
            poisonCount -= POISON_COST
        }
    }

    companion object {
        const val DEFAULT_POISON_COUNT = 5
        const val POISON_DAMAGE_RATIO_OF_MAX_HP = 5
        const val POISON_COST = 1
        const val MSG_POISON_ATTACK = "독 포자를 살포했다!"
    }
}
