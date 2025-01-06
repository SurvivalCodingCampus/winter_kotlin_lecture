package day13
// 자바스타일
// 싱글턴 : 하나의 인스턴스만 가짐
object Weather

fun Weather.tomorrow(): String {
    Thread.sleep(2000)      // 스레드가 블록되는 문제가 있음
    return "맑음"
}

fun main() {
    val data = Weather.tomorrow()
    print("내일 날씨는 $data")
}