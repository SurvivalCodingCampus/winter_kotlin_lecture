package day03

import utils.SystemFunction


class Cleric(
    var name: String,
    var hp: Int = MAX_HP,
    var mp: Int = MAX_MP
) : SystemFunction {

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

        // 힐량이 MaxMp를 초과하는 경우와 그렇지 않은 경우로 구분
        return when {
            healAmount + mp > MAX_MP -> {
                val heal = MAX_MP - mp
                mp = MAX_MP
                heal
            }

            else -> {
                mp += healAmount
                healAmount
            }
        }
    }

    override fun showStatus() {
        println("------- 현재 상태 출력 -------")
        println("이름: ${this.name} hp: ${this.hp}, mp: ${this.mp}")
        println("")
    }


    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
    }


}

fun main() {
    val clericA = Cleric(name = "아서스", hp = 40, mp = 5)

    val clericB = Cleric(name = "아서스", hp = 35)

    val clericC = Cleric(name = "아서스")
    clericA.showStatus()
    clericB.showStatus()
    clericC.showStatus()

    //val clericD = Cleric()

//    println("(A) 인스턴스 속성 출력: name:  ${clericA.name}, hp : ${clericA.hp}, mp: ${clericA.mp}")
//
//    println("(B) 인스턴스 속성 출력: name:  ${clericB.name}, hp : ${clericB.hp}, mp: ${clericB.mp}")
//
//    println("(C) 인스턴스 속성 출력: name:  ${clericC.name}, hp : ${clericC.hp}, mp: ${clericC.mp}")
}