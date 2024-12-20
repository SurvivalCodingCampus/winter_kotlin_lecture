package com.survivalcoding.day04

import com.survivalcoding.day03.Hero

fun main() {

    var hero1: Hero = Hero(name = "홍길동", hp = 100)

//    hero1 = null

    val hero2 = hero1

//    hero2.hp = 200

    println(hero1.hp)
}