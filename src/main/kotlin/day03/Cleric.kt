package day03

class Cleric(var name: String, var hp: Int = MAX_HP, var mp: Int = MAX_MP) {

    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
    }

    fun selfAid() {
        if (mp < 5) return

        mp -= 5
        hp = MAX_HP
    }

    fun pray(seconds: Int): Int {
        val healingAmount = seconds + (0..2).random()
        val actualRecover = if (mp + healingAmount > MAX_MP) {
            MAX_MP - mp
        } else {
            healingAmount
        }
        mp += actualRecover

        return actualRecover
    }

}
