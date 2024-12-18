package org.example.day03

open class Hero(
    open var name: String,
    open var hp: Int = 50,
    open var mp: Int = 10,
) {

    fun attack() {}

//    open fun getDamaged(damagedNum: Int) {
//
//        println("1: $hp")
//        if (hp != 0 && damagedNum > 0) hp -= damagedNum
//        if (damagedNum > hp) hp = 0
//        if (damagedNum < 0) return
//        println("2: $hp")
//    }

    fun run() {}
    fun sleep() {}
    fun usingSkills() {


    }
}
