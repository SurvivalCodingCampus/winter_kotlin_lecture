package org.example.day11

fun main() {
    try {
        someError()
    } catch (e: Exception) {
        throw e
    }
}

fun someError() {
    throw Exception("에러")
}