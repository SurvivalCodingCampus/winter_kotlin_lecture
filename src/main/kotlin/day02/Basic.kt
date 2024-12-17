package org.example.day02

fun main() {
    val name2: String? = null
    val name3: String = ""

    println(name2?.uppercase())
    println(name3.uppercase())

    //상수
    val number = 10

    //변수
    var name = "길동"
    name = "석봉"

    println(plus5(10))

    val fullName = "홍$name"

    val a = 10
    val b = 5
    val c = if (a > b) a else b

    val items = listOf("apple", "banana") //리스트 변경 불가
    println(items)

    for (item in items) {
        println(item)
    }
}

fun plus5(x: Int): Int = x + 5

fun printSum(a: Int, b: Int) {
    println(a + b)
}

//java에 void는 kotlin에서 unit(생략가능)