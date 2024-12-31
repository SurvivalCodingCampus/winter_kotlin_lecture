package day11

fun main() {
    var num: Int = 0

    try {
        val numString = "10.5"
        num = numString.toInt()
    } catch(e: NumberFormatException) {
        println(e.message)
        println("num의 값이 0으로 세팅됩니다.")
    } finally {
        println(num)
    }

}