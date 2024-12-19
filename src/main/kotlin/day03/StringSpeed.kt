package org.example.day03

import kotlin.time.measureTime

fun main() {
    val time = measureTime {
        var text = ""
        repeat(100000) {
            text += "1"
        }
    }
    // StringBuilder 사용 X 414.759084ms
    println("StringBuilder 사용 X $time")
    val timeWithStringBuilder = measureTime {
        val text = StringBuilder()
            repeat(100000) {
                text.append("1")
            }
    }
    // StringBuilder 사용 0 3.011708ms
    println("StringBuilder 사용 0 $timeWithStringBuilder")
}