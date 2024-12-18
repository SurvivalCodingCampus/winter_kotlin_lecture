package day03


class Cleric(
    var name: String = "클레릭",
    var hp: Int = 50,
    var mp: Int = 10,
) {

    fun selfAid() {
        // 마력이 부족하다면 사용 취소
        if (mp < 5) return

        mp -= 5
        hp = MAX_HP
    }

    fun pray(praySecond: Int): Int {

        // 초는 음수나 0 x
        if (praySecond <= 0) return 0

        // 회복량
        val healAmount = (0..2).random() + praySecond

        // 실제 회복된 MP 양
        val realHealAmount: Int

        // 회복량이 초과될경우 현재 mp 최대 mp로 맞춰주기
        if (healAmount + mp > MAX_MP) {
            realHealAmount = MAX_MP - mp
            mp = MAX_MP
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

    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
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