package day12

interface OnCompleteCallback {
    fun onComplete()
}

class Timer {
    fun start(callback: OnCompleteCallback) {   // 콜백 인터페이스를 파라미터로 받고 특정 시점에 메서드를 호출
        println("타이머 시작")
        Thread.sleep(2000)
        callback.onComplete()
    }
}

fun main() {
    val timer = Timer()
    timer.start(object : OnCompleteCallback {
        override fun onComplete() {
            println("땡")
        }
    })
}
