package day3

import kotlin.time.measureTime

fun main() {
    val result = measureTime { // 코드 실행시간을 측정해주는 공식 라이브러리
        repeat(1000) { // 간편하게 반복시켜주는 확장함수
        }
    }
    println(result) // Duration type
}