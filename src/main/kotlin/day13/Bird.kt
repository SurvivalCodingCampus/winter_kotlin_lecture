package day13

import kotlinx.coroutines.*

/*
연습문제2. 매일 아침, 당신은 새소리에 잠에서 깹니다. 시간이 지나면서, 당신은 세 가지 독특한 새소리를 알아차렸고, 각각 다른 간격으로 반복되는 것을 발견했습니다.

한 새는 1초마다, 다른 새는 2초마다, 마지막 새는 3초마다 소리를 냅니다.

요구사항
각 새의 소리 타이밍을 재현하되, 각 새마다 하나의 코루틴을 사용하세요. 각 코루틴은 4번만 출력한 후 완료되어야 합니다.
첫 번째 새는 "꾸우" 소리를 냅니다.
두 번째 새는 "까악" 소리를 냅니다.
마지막 새는 "짹짹" 소리를 냅니다.

꾸우 1
까악 1
짹짹 1
꾸우 2
까악 2
꾸우 3
짹짹 2
꾸우 4
까악 3
짹짹 3
까악 4
짹짹 4

연습문제3. 새들에 의해 잠에서 깬 후, 당신은 잠시 동안 그들의 소리를 즐겁게 듣습니다.
그 후, 하루를 준비해야 하므로 잠시 새소리를 들은 후 창문을 닫고 준비를 시작합니다.

요구사항
이전 과제를 확장하여 콘솔에 4번만 출력하는 제한을 제거하세요.
이제 각 코루틴은 무기한으로 출력할 수 있습니다.
10초 후에 모든 실행 중인 코루틴을 취소하는 메커니즘을 추가하세요.
꾸우
까악
짹짹
꾸우
까악
꾸우
짹짹
꾸우
까악
꾸우
꾸우
까악
짹짹
꾸우
꾸우
까악
꾸우
짹짹
꾸우
*/


suspend fun bird1() {
    while(true) {
        println("꾸우")
        delay(1000L)
    }
}

suspend fun bird2() {
    while(true) {
        println("까악")
        delay(2000L)
    }
}

suspend fun bird3() {
    while(true) {
        println("짹짹")
        delay(3000L)
    }
}

fun main() = runBlocking {
    val job1 = launch { bird1() }
    val job2 = launch { bird2() }
    val job3 = launch { bird3() }

    val cancelJob: Job = launch {
        delay(10000L)
        job1.cancel()
        job2.cancel()
        job3.cancel()
    }

    cancelJob.join()
}