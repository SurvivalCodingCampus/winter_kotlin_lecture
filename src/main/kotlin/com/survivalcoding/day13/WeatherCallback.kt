package com.survivalcoding.com.survivalcoding.day13

// 싱글턴
object Weathers

fun Weathers.tomorrow(callback: (String) -> Unit) {
    Thread.sleep(2000)
    callback("맑음")
}

fun main() {
    println("1")
    Weathers.tomorrow { data ->
        println("2")
        println("내일 날씨는 $data")
    }
    println("3")
}