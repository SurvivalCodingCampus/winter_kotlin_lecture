package day03

fun main() {
    val hero = Hero("홍길동", 100)
    //자바는 파라미터 순서 바꾸려면 오버로드 해야하는데, 코틀린은 걍 내가 설정가능(hp=100, name="홍길동")
    println(hero.hp)
    hero.sleep()
    println(hero.hp)

    val slime = Slime(hp = 50, suffix = "A")
    println()

}

class Hero(var name : String, var hp: Int = 100 ) { //초기값
    //메소드
    fun attack() {}
    fun run() {}

    fun sleep() {
        hp = 100
        println("${name}은 잠을 자고 회복했다 : $hp")
    }
    fun pung(): String {
        return "뽕"
    }
}

