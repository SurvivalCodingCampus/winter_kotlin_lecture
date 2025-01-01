package day11

/* try-catch() 문을 사용하여 예외처리를 하시오.
예외처리에는 다음의 처리를 수행하시오.
예외가 발생하면 0으로 처리 */

fun main() {
    val numString = "10.5"
    var num: Int = 0

    try {
        num = numString.toInt()
    } catch (e:NumberFormatException) {
        num = 0
    } finally {
        println(num)
    }

}