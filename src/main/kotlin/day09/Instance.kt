package org.example.day09

import org.example.day03.Hero

fun main() {
    val heroes = mutableListOf<Hero>()

    val h1 = Hero("홍길동")    // 자바에서는 Any말고 Object임
    val h2 = Hero("홍길동")    // 자바에서는 Any말고 Object임

    println(h1.hashCode())
    println(h2.hashCode())

//    println(h1 == h2)
//    println(h1 === h2)

    heroes.add(h1)
    println(heroes.size)

//    heros.remove(h2)
    heroes.remove(Hero(name = "홍길동", hp = 200))
    println(heroes.size)

    // 인스턴스 기본 조작 연습문제 1번
    val book1: Book


}