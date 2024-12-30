package day08

import org.example.day04.Enemy

abstract class Character(
    val name: String,
    var hp: Int,
    var mp: Int,
) {
    abstract fun attack(enemy: Enemy): Unit
    abstract fun defend(): Unit
    abstract fun run(): Unit
}