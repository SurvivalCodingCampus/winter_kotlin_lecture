package com.survivalcoding.day03

import kotlin.time.measureTime

fun main() {
    val time = measureTime {
        var text = StringBuilder("")
        repeat(1000000) {
            text.append("1")
        }
    }
    println(time)

//    val time = measureTime {
//        var text = ""
//        repeat(1000000) {
//            text += "1"
//        }
//    }
//    println(time)
}