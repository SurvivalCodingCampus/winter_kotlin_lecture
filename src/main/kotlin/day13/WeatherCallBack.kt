package org.example.day13

// singleton object
object Weather2

fun Weather2.tomorrow(callback: (String) -> Unit) {
    Thread.sleep(2000)
    callback("맑음")
}

fun main() {
    println(1)
    // 코틀린에서는 callback 을 좋아함
    Weather2.tomorrow { data ->
        println(2)
        println("내일 날씨는 $data")
    }
    println(3)
}