package org.example.day05

class Person(
    var name: String,
    var age: Int,
) {
    fun bye() {}
}

// 여관 클래스의 오류
//class Inn {
//    fun checkIn(hero: Hero) {
//        hero.hp = -100
//    }
//}

//class King{
//    fun callHero(hero: Hero){
//
//    }
//}

fun main() {
    val person = Person("홍길동", 10)
    person.age = 11

}