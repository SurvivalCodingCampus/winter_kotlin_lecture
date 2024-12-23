package org.example.day02

fun main() {
    println("Hello World!")

    // 상수
    val number = 10

    // 변수
    var name = "홍길동"
    
    println(plus5(10));
}

// 함수
/*
* 타입은 ":" 뒤에 작성
* 반환형은 함수 끝에 ":" 뒤에 작성 
* */
fun plus5(x: Int) : Int {
    return x + 5
}

// 이런 식으로 return이 한 가지일 경우 식 형식으로도 함수 정의 가능
fun plus7(x: Int) : Int = x + 7

// return type을 유추해서 return 타입도 생략 가능
fun plus8(x: Int) = x + 8

// void = Unit
fun plusab(a: Int, b: Int) : Unit {
    println(a + b)
}