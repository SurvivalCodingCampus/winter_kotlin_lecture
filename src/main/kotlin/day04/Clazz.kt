package com.survivalcoding.day04

import com.survivalcoding.day03.Hero

fun main() {

    val hero1 = Hero(name = "홍길동", hp = 100)
    val hero2 = hero1

    hero2.hp = 200

    println(hero1.hp)
}