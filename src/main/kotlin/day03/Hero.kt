package org.example.day03

fun main() {
//    val hero = Hero("홍길동", 100)
    val hero = Hero(name = "홍길동", hp = 50)
    println(hero.hp)
    hero.sleep()
    println(hero.hp)

    val slime = Slime(hp = 100, suffix =  "A")
    println(slime.suffix)
    println(slime.hp)
}


class Hero(
    // var : 안에서 접근 가능
    // val : 읽기 전용
    var name: String,
    // 초기값
    var hp: Int = 100,
) {
    var food = ""

    /// 메소드
    fun attack() {}

    fun run() {}

    fun sleep() {
        hp = 100
        println("$name 은 잠을 자고 회복했다 : $hp")
    }

    fun pung(): String {
        // 먹은(Food)게 있으면 뿡
        // 없으면 뽕
        return if (food.isNotEmpty()) {
            "뿡"
        } else {
            "뽕"
        }
    }
}