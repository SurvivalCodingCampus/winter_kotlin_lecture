package day08.example

class Slime(val suffix: String): Monster() {
    var hp = 50
    override fun run() {
        println("슬라임 $suffix 가 도망")
    }
}

fun main() {
    val slime = Slime("A")
    val monster: Monster = Slime("B")
    slime.run()
    monster.run()
}