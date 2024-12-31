package org.example.day10

fun main() {
    val str1 = "hello"
    val str2 = "hello"
    println(str1 === str2)

    val str3 = String("hello".toCharArray())
    println(str1 === str3)

    val str4 = "hel" + "lo"
    println(str1 === str4)

    val str5 = "hel" + getLo()
    println(str1 === str5)

    val greeting = "Hello"
    println(greeting.replace("H", "J"))
    println(greeting)
}

fun getLo() = "lo"

fun aa() {
    val str1 = "hello"
    val str2 = "hello"
}