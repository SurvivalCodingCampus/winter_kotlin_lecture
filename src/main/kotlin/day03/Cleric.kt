package day03

const val maxHp: Int = 50
const val maxMp: Int = 10

class Cleric(
    var name: String,
    var hp: Int = 50,
    var mp: Int = 10,
) {
    fun selfAid() {
        if (mp < 5) {
            println("mp가 부족합니다")
        } else if (hp == maxHp) {
            println("hp가 최대치 입니다")
        } else {
            mp -= 5
            hp = maxHp      //mp -5 한번에 최대 hp까지 풀 충전 완료
            println("hp가 회복되었습니다")
        }
    }

    fun pray(time: Int): Int {
        val num = (0..2).random()
        var recoveryMp = time + num
        var currentMp = mp
        if (recoveryMp + currentMp > maxMp) {
            return maxMp - currentMp
        }
        return recoveryMp
    }
}

fun main() {
    var hero = Cleric("용사")
    hero.selfAid()
    hero.pray(3)
}