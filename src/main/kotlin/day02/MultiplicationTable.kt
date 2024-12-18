package org.example.day02

fun main() {
    multiply(3)
}

/**
 * 입력받은 숫자의 구구단을 출력합니다.
 * @param number 출력할 구구단의 단 (1-9)
 * @throws IllegalArgumentException 입력값이 1-9 범위를 벗어날 경우
 */
fun multiply(number: Int) {
    require(number in 1..9) { "1부터 9 사이의 숫자를 입력해주세요." }
    println("=== $number 단 ===")
    for (i in 1..9) {
        println("$number x $i = ${number * i}")
    }
}
