package day03

class Cleric(
    val name: String = "",
    var hp: Int = 50,
    val maxHp: Int = 50,
    var mp: Int = 10,
    val maxMp: Int = 10,
) {

    fun selfAid() {
        mp -= 5
        hp = maxHp
    }

    fun pray(praySecond: Int): Int {

        // 회복량
        val healAmount = (0..2).random() + praySecond

        // 실제 회복된 MP 양
        val realHealAmount: Int

        // 회복량이 초과될경우 현재 mp 최대 mp로 맞춰주기
        if (healAmount + mp > maxMp) {
            realHealAmount = maxMp - mp
            mp = maxMp
        } else {
            realHealAmount = healAmount
            mp += healAmount
        }

        return realHealAmount
    }

    fun showStatus() {
        println("------- 성직자의 현재 상태를 출력합니다 -------")
        println("hp: ${this.hp}")
        println("mp: ${this.mp}")
    }
}

fun main() {
    val cleric = Cleric(hp = 50, mp = 10)
    cleric.showStatus()
    cleric.selfAid()
    cleric.showStatus()
    cleric.pray(2)
    cleric.showStatus()
}