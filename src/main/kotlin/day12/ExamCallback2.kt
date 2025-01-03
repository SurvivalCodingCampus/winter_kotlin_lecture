package day12

class Timer2 {
    fun start(callback: () -> Unit) {
        println("타이머 시작")
        Thread.sleep(2000)
        callback()
    }
}


fun main() {
    // 방법1. 람다
    val timer = Timer2()
    timer.start {
        println("땡")
    }


    // 방법2. 함수 레퍼런스로 전달
    fun onComplete() {
        println("땡")
    }
    timer.start(::onComplete)
}