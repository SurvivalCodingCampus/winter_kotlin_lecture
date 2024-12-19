package day03

import kotlin.time.measureTime

//fun main() {
//    var time = measureTime {
//        var text = ""
//        repeat(100000) {
//            text += "1"           //일반 문자열(String 불변객체)을 사용한 문자열 연결.
//        }
//    }
//    println(time)
//}

fun main() {
    var time = measureTime {
        var text = StringBuilder("")
        repeat(100000) {
            text.append("1")        //StringBuilder(가변 객체로 설계되어 있음)를 사용한 문자열 추가
        }                           //기존 메모리 공간을 재사용하며 문자열을 추가하므로 훨씬 빠름
    }
    println(time)
}