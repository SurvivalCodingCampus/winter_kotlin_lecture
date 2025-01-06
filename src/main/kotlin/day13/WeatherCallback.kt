package day13

// 콜백 활용
object Weathers

fun Weathers.tommorow(callback: (String) -> Unit): Unit {
    Thread.sleep(1000)
    callback("맑음")
}

fun main() {
    Weathers.tommorow { data ->
        println("내일 날씨는 $data")
    }

}