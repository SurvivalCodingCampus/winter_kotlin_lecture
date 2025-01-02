package com.survivalcoding.com.survivalcoding.day12

fun main() {
    listOf(3).reduce { acc, i -> i }

//    command({ damage -> println() })

    // 무명클래스
    Timer().start {
        println("땡!")
    }
}

//interface OnCompleteCallback {
//    // input도 없고 output도 없는 함수
//    fun onComplete(): Unit
//}

class Timer {
    fun start(callback: () -> Unit) {
        println("타이머 시작")
        Thread.sleep(3000)
        callback()
    }
}


class MyComparator : Comparator<Int> {
    override fun compare(o1: Int?, o2: Int?): Int {
        return o1!! - o2!!
    }
}

fun command(func: Attackable) {

}

// SAM
interface Attackable {
    fun attack(damage: Int)
}