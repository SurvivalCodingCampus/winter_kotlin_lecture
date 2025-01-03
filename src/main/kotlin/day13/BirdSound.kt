package org.example.day13

import kotlinx.coroutines.*

fun main(): Unit = runBlocking {

    launch {
        repeat(4) {
            delay(1000)
            println("꾸우")
        }
    }

    launch {
        repeat(4) {
            delay(2000)
            println("까악")
        }
    }

    launch {
        repeat(4) {
            delay(3000)
            println("짹짹")
        }
    }
}

/*
* 매일 아침, 당신은 새소리에 잠에서 깹니다. 시간이 지나면서, 당신은 세 가지 독특한 새소리를 알아차렸고, 각각 다른 간격으로 반복되는 것을 발견했습니다.

한 새는 1초마다, 다른 새는 2초마다, 마지막 새는 3초마다 소리를 냅니다.

요구사항
각 새의 소리 타이밍을 재현하되, 각 새마다 하나의 코루틴을 사용하세요. 각 코루틴은 4번만 출력한 후 완료되어야 합니다.
첫 번째 새는 "꾸우" 소리를 냅니다.
두 번째 새는 "까악" 소리를 냅니다.
마지막 새는 "짹짹" 소리를 냅니다.
*/