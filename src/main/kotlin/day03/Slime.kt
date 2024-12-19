package day03

class Slime(hp: Int, private val suffix: String) {

    private val level = 10

    fun attack() {
        println("슬라임 ${suffix}가 공격한다.")
    }

    fun run() {
        println("슬라임 ${suffix}가 도망갔다.")
    }
}

fun main() {
    // 용사 생성
    val hero = Hero(name = "용사", hp = 100)
    val slime1 = Slime(hp = 50, suffix = "조무래기1")
    val slime2 = Slime(hp = 100, suffix = "조무래기2")

    hero.attack()
    slime1.run()
    slime2.run()
    hero.run()
    hero.sleep()

}