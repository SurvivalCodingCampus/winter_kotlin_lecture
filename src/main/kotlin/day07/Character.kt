package org.example.day07

fun main() {
    // 추상 클래스는 인스턴스를 생성할 수 없다.
    // val character = Character("캐릭터", 100)
}

abstract class Character(
    var name: String,
    var hp: Int,
) {
    fun run() = println("run")

    /// 추상 메소드
    /// 상속을 받으면 override가 강제 됨
    abstract fun attack(character: Character)
}


