package day13

fun main() {
    println(Thread.currentThread())  // 현재 스레드 확인(메인)
    /*만약 앱개발하는데 메인스레드 하나에서 네트워크 요청해서 뿌린다.
            요청하고 오는 동안 아무것도 안하고 스레드가 블럭되고 프로그램이 멈춘것 같이 된다.
            데이터 오면 그 다음 동작하게 됨.*/
    Thread {
        Thread.sleep(1000)
        println("쿵")
    }.start()

    Thread {
        println("짝")
    }.start()

    // 짝이 먼저 나오고 다음에 쿵이 나온다.
    // 문제는? 개발자가 프로그램 흐름을 놓치게 된다.
}