package day03

fun main() {
    // 가상 세계에 용사를 생성
    // 용사는 이름과 hp를 반드시 가져야 함
    val hero = Hero(name = "홍길동", hp = 50)
    println(hero.hp)
    hero.sleep()
    println(hero.hp)

    // 슬라임 한마리 생성
    val slime = Slime(hp = 50, suffix = "A")
    println(slime.suffix)
    println(slime.hp)

    slime.run()

}

class Hero(var name: String, var hp:Int) {
    var food = ""
    fun attack() {}
    fun run() {}

    fun sleep() {
        hp = 100
        println("${name}은 잠을 자고 회복했다 : $hp")
    }
}

class Slime(var suffix: String, var hp:Int) {
    val level = 10
    fun run() {
        println("슬라임 ${suffix}가 도망갔다")
    }
}