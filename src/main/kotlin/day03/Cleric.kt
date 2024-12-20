package day03

class Cleric(
    var name: String,
    var hp: Int = MAX_HP,
    var mp: Int = MAX_MP
) {
    override fun toString(): String {
        return "name = '$name', hp = $hp, mp = $mp"
    }

    companion object {
        const val MAX_HP: Int = 50
        const val MAX_MP: Int = 10
    }
//    constructor(name: String) : this(name, MAX_HP, MAX_MP)
//    기본 생성자에서 처리하고 있어서 재정의하지 않아도 됨

    fun selfAid() {
        if (mp < 5) {
            println("mp가 부족합니다")
        } else if (hp == MAX_HP) {
            println("hp가 최대치 입니다")
        } else {
            mp -= 5
            hp = MAX_HP      //mp -5 한번에 최대 hp까지 풀 충전 완료
            println("hp가 회복되었습니다")
        }
    }

    fun pray(time: Int): Int {
        val num = (0..2).random()
        var recoveryMp = time + num
        var currentMp = mp
        if (recoveryMp + currentMp > MAX_MP) {
            return MAX_MP - currentMp
        }
        return recoveryMp
    }

}


fun main() {
    var hero = Cleric("용사")
    hero.selfAid()
    hero.pray(3)

    var cleric1: Cleric = Cleric(name = "아서스", hp = 40, mp = 5)
    var cleric2: Cleric = Cleric("아서스", hp = 35)
    var cleric3: Cleric = Cleric("아서스")

    println(cleric1.toString())
    println(cleric2.toString())
    println(cleric3.toString())

}
