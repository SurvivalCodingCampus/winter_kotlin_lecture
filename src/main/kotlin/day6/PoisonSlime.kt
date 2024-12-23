package day6

import day3.Slime


class PoisonSlime(hp: Int, suffix: String) : Slime(suffix, hp) {
    companion object {
        const val DEFAULT_POISON_CHARGE = 5
    }

    private var poisonCharges: Int = DEFAULT_POISON_CHARGE
    override fun attack() {
        super.attack()

        if (target == null || poisonCharges <= 0) return
        println("추가로 독 포자를 살포했다!")
        target!!.hp.percent -= 20
        --poisonCharges
    }

}