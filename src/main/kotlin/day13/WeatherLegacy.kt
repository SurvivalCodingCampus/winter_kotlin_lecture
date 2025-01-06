package day13

// JAVA 스타일. 스레드 직접 활용
// 싱글턴
object Weather

fun Weather.tommorow(): String {
    Thread. sleep(2000)
    return "맑음"
}

fun main() {
    val data = Weather.tommorow()
    println("내일 날씨는 $data")
}