package com.survivalcoding.com.survivalcoding.day02

const val MAX_COUNT = 8

fun main() {

    println("Hello World")

    // 상수
    val number = 10     // Int

    // 변수
    var name = "길동"    // String
    name = "석봉"

    println(plus5(10))

    val fullName = "홍$name"

    val a = 10
    val b = 5
    val d = true
    val c = if (a > b) a else b

    // 수정 안 되는 리스트
    val items: List<String> = listOf("apple", "banana")
    println(items)

    for (item in items) {
        println(item)
    }

    // Null Safety
    val name2: String? = null
    val name3: String = ""

    println(name2?.uppercase())
    println(name3.uppercase())
}

// f(x) = x + 5
// f(5) = 25
// f(3) = ?

//function sum(a, b) {
//
//}

fun plus5(x: Int): Int = x + 5

fun printSum(a: Int, b: Int) {
    println(a + b)
}

// Java: void printSum(int a, int b) { }