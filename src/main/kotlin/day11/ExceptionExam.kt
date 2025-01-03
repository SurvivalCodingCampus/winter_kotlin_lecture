package org.example.day11

fun main() {
//    exam1
//    try {
//        someError2()
//    } catch (e: Exception) {
//        e.printStackTrace()
//        println("Error: ${e.message}")
//    }
    try {
        someError2()
    } catch (e: IllegalStateException) {
        println("IllegalStateException: ${e.message}")
    } catch (e: Exception) {
        println("Error: ${e.message}")
    } finally {
        // 예외 발생 여부와 상관없이 실행
        println("Finally")
    }
}

fun someError2() {
    try {
        someError1()
    } catch (e: Exception) {
        throw e
    }
}

fun someError1() {
    throw Exception("Some error")
}