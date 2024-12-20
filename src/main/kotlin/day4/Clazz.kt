package org.example.day4

import org.example.day03.Hero

//companion object 는 JAVA의 static과 비슷한 역할을 한다.

//class Hero(val name: String, var hp: Int) {
//    companion object {
//        const val MAX_HP = 200
//    }
//
//}

fun main() {
    /// instance는 하나
    /// 참조는 두개
    /// 컴퓨터 내부적으로는 주소를 가지고 논다..

    // hero1과 hero2는 같은 주소를 가리키고 있음
    val hero1 = Hero("홍길동", 100)
    val hero2 = hero1

    hero2.hp = 200

    // hero1과 hero2는 같은 주소를 가리키고 있기 때문에 hero1.hp도 200이 됨
    println(hero1.hp)
}