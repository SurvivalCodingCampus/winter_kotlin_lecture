package com.survivalcoding.com.survivalcoding.day03

import kotlin.math.min

class Person3(
    var age: Int,
) {
    operator fun plus(value: Int): Person3 {
        return Person3(age + value)
    }
}

fun main() {
    val person3 = Person3(10)
    person3.apply { }

    var nullType: String? = null

    if (nullType == null) {
        return
    }

//    if (nullType != null) {
//
//    }
    println(nullType.uppercase())


    var person = Person3(10)

    person += 20

    println(person.age)


    val cleric1 = Cleric("아서스", hp = 40, mp = 5)
    Cleric("아서스", hp = 35)
    Cleric("아서스")
//    Cleric()
}

class Cleric(
    val name: String,
    var hp: Int = MAX_HP,
    var mp: Int = MAX_MP,
) {

    companion object {
        const val MAX_HP = 50
        const val MAX_MP = 10
    }

    fun selfAid() {
        if (mp < 5) {
            return
        }

        mp -= 5
        hp = MAX_HP
    }

    fun pray(sec: Int): Int {
        if (sec < 1) {
            return 0
        }

        if (mp == MAX_MP) {
            return 0
        }

        val randomNumber = (0..2).random()

        val currentMp = mp

        mp += min(sec + randomNumber, MAX_MP)

        return mp - currentMp
    }
}