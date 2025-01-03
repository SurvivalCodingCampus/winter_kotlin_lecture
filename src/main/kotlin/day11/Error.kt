package day11

fun main() {
// runtime error를 try-catch()문으로 예외처리
// 예외 발생 시 0으로 처리
    val numString = "10.5"
    var num = 0
    try {
        num = numString.toInt()
    } catch (e: Exception) {
        println("변환 실패: ${e.message}")
    }
    println(num) // 예외 발생 시 초기값(0) 출력
}

//val num = numString.toIntNull() ? : 0