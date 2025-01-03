package org.example.day13

// 싱글턴. 인스턴스 1개만 생성
object Weather

fun Weather.tomorrow(): String {
    Thread.sleep(2000) // 2초간 처리
    return "맑음"
}

fun main() {
    val data = Weather.tomorrow()
    println("내일 날씨는 $data")
}