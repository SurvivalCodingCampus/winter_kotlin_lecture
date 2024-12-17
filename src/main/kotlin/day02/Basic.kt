package org.example.day02

fun main() {
    println("Hello World")
    // 상수
    val number = 10

    // 변수
    var name = "길동"
    name = "석봉"

    println(plus5(10))

    // $ 기호 사용
    val fullName = "홍${name}"

    val a = 10
    val b = 5
    val c = if(a > b) a else b

    // 수정이 안 되는 리스트
    // kotlin은 불변을 선호
    val items = listOf("apple", "banana")
    println(items)
    for(item in items){
        println(item)
    }

    // Null Safety
    val name2:String? = null
    val name3:String = ""
    println(name2?.uppercase())

    
}

fun plus5(x: Int): Int = x + 5
fun printSum(a:Int, b:Int) {
    print(a+b)
}