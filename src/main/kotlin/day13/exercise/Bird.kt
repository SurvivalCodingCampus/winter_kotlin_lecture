package day13.exercise

import kotlinx.coroutines.*

/*
* 매일 아침, 당신은 새소리에 잠에서 깹니다. 시간이 지나면서, 당신은 세가지 독특한 새소리를 알아차렸고, 각각 다른 간격으로 반복되는 것을 발견했습니다.
* 한새는 1초마다, 다른 새는 2초마다, 마지막 새는 3초마다 소리를 냅니다.
*
* 요구사항
* 각 새의 소리 타이밍을 재현하되, 각 새마다 하나의 코루틴을 사용하세요. 각 코루틴은 4번만 출력한 후 완료되어야 합니다.
* 1. 첫번째 새는 "꾸우" 소리를 냅니다.
* 2. 두번째 새는 "까악" 소리를 냅니다.
* 3. 마지막 새는 "짹짹" 소리를 냅니다.
* */


// 연습문제 2번

//fun main() = runBlocking {
//    repeat(4) {
//        firstBird()
//        secondBird()
//        thirdBird()
//    }
//}


//// 연습문제 3번 첫번째 방법
//fun main() = runBlocking {
//    val job = launch {
//        while (true) {
//            firstBird()
//            secondBird()
//            thirdBird()
//        }
//    }
//    delay(10000L)
//    job.cancel()
//}

// 연습문제 3번 두번째 방법
fun main() = runBlocking {
    val result = withTimeoutOrNull(10000L) {
        while (true) {
            firstBird()
            secondBird()
            thirdBird()
        }
    }
    println(result ?: "코루틴 취소")
}


// 1초마다 꾸우
suspend fun firstBird() {
    delay(1000L)
    println("꾸우")
}

// 2초마다 까악
suspend fun secondBird() {
    delay(2000L)
    println("까악")
}


// 3초마다 짹짹
suspend fun thirdBird() {
    delay(3000L)
    println("짹짹")
}