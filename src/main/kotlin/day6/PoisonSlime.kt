package day6

import day3.Slime


class PoisonSlime(suffix: String, hp: Int = 50) : Slime(suffix, hp) {
    companion object {
        const val DEFAULT_POISON_CHARGE = 5
        const val DEFAULT_POISON_DAMAGE_PERCENT = 20F
    }

    var poisonCharges: Int = DEFAULT_POISON_CHARGE

    override fun attack() {
        super.attack()

        if (target == null || poisonCharges <= 0) return
        target!!.hp.percent -= DEFAULT_POISON_DAMAGE_PERCENT
        --poisonCharges
        println("추가로 독 포자를 살포했다!")
    }

}