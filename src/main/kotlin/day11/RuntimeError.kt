package org.hyunjung.day11

fun main() {
    val numString = "10.5"
    try {
        println(numString.toInt())
    } catch (e: RuntimeException) {
        println(0)
    }
}