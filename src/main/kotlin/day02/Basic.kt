package org.hyunjung.day02

fun main() {
    println("Hello World")

    // 상수
    val number = 10

    // 변수
    var name = "길동"
    name = "석봉"

    println(plus5(10))

    val fullName = "홍 $name"

    val a = 10
    val b = 5
    val c = if (a > b) a else b

    // 수정 안되는 리스트
    val items = listOf("apple", "banana")
    println(items)

    for (item in items.indices) {
        println(item)
    }

    val name2: String? = null
}

// y = f(x)
fun plus5(x: Int) = x + 5

// Java: void printSum(int a, int b) { }
fun printSum(a: Int, b: Int) {
    println(a + b)
}