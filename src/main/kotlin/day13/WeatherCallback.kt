package org.example.day13

// 싱글턴. 인스턴스 1개만 생성
object Weathers

fun Weathers.tomorrow(callback: (String) -> Unit) {
    Thread.sleep(2000) // 2초간 처리
    callback("맑음")
}

fun main() {
    Weathers.tomorrow { data ->
        println("내일 날씨는 $data")
    }
}