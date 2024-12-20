package com.survivalcoding.day05

import com.survivalcoding.day03.Hero

class Person(
    var name: String,
    var age: Int,
) {
    fun bye() {}
}

fun main() {
    val person = Person("홍길동", 10)
    person.age = 11

    val hero = Hero("한석봉")
    hero.name = ""
}