package day03


fun main() {
    val hero = OldHero(name = "홍길동", hp = 50)
    println(hero.hp)
    println(hero.hp)
}

class OldHero(
    var name: String,
    hp: Int,
    var sword: Sword? = null
) {
    private var _hp = hp
    val hp: Int
        get() = _hp

    // 메소드
    fun attack() = println("${name}은 공격중")
    fun run() = println("${name} 뛰는중")
    fun sit(sec: Int) = println("${name}은 ${sec}초 동안 앉아 있다.")
    fun slip() = println("${name}은 넘어졌다.")
//    fun sleep() {
//        hp = 100
//        println("${name}은 잠을 자고 회복했다 : $hp")
//    }

    fun bye() {
        println("빠이")
    }

    private fun die() {
        println("죽었다")
    }
}