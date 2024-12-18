package org.example.day03

fun main() {
    val hero = Hero("홍길동", 100)
    hero.attack()
}

class Hero(var name: String, var hp: Int) { // 클래스 명 뒤에 괄호가 생성자를 의미한다.

    fun attack() {}
    fun run() {}
    fun sleep() {}
}

