package com.survivalcoding.com.survivalcoding.day03

class Sword(val power: Double) {

}

// ==, hashCode, toString, copy
data class Slime(
    var hp: Int,
    val suffix: String,
    var sword: Sword? = null
) {

    val level = 10

    fun attack() {

    }
}

fun main() {
    val slime = Slime(hp = 100, suffix = "A")
    val slime2 = Slime(hp = 100, suffix = "A")
    println(slime === slime2)    //

    val (hp, suffix) = Slime(hp = 100, suffix = "A")
}