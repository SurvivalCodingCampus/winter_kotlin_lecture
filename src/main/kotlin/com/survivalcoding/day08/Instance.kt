package com.survivalcoding.com.survivalcoding.day08

import com.survivalcoding.com.survivalcoding.day03.Hero

fun main() {
    val heroes = mutableSetOf<Hero>()
    val h1 = Hero(name = "슈퍼맨", hp = 100)
    val h2 = Hero(name = "슈퍼맨", hp = 100)

    println(h1 === h2)

    println(h1.hashCode())
    println(h2.hashCode())

//    println(h1 == h2)

    heroes.add(h1)
    println(heroes.size)
//?
    heroes.remove(Hero(name = "홍길동", hp = 200))
    println(heroes.size)
// ?
}
//fun main() {
//    val obj = Hero("홍길동")
//    println(obj)
//
//
//}

class Person {

}