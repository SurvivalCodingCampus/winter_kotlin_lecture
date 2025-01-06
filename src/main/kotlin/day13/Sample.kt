package day13

import com.sun.source.tree.Tree

//fun main() {
//    println(Thread.currentThread())
//    println("쿵")
//    Thread.sleep(1000)  // Thread Block
//    println("짝")
//}

fun main() {        // 이렇게 하면 '짝 쿵' 이렇게 나옴
    println(Thread.currentThread())
    Thread {
        Thread.sleep(500)
        println("쿵")
    }.start()       // .start()는 새로운 스레드를 시작하는 메서드
    Thread {
        println("짝")
    }.start()
}