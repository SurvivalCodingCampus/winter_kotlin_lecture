package day03


fun main() {
    val hero = Hero(name = "홍길동", hp = 50)
    println(hero.hp)
    hero.sleep()
    println(hero.hp)
}

class Hero(
    var name: String,
    var hp: Int,
) {
    // 메소드
    fun attack() = println("${name}은 공격중")
    fun run() = println("${name} 뛰는중")
    fun sit(sec: Int) = println("${name}은 ${sec}초 동안 앉아 있다.")
    fun slip() = println("${name}은 넘어졌다.")
    fun sleep() {
        hp = 100
        println("${name}은 잠을 자고 회복했다 : $hp")
    }
}