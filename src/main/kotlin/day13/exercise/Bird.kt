package day13.exercise

import kotlinx.coroutines.*

/*
* 매일 아침, 당신은 새소리에 잠에서 깹니다. 시간이 지나면서, 당신은 세가지 독특한 새소리를 알아차렸고, 각각 다른 간격으로 반복되는 것을 발견했습니다.
* 한새는 1초마다, 다른 새는 2초마다, 마지막 새는 3초마다 소리를 냅니다.
*
* <요구사항>
* 각 새의 소리 타이밍을 재현하되, 각 새마다 하나의 코루틴을 사용하세요. 각 코루틴은 4번만 출력한 후 완료되어야 합니다.
* 1. 첫번째 새는 "꾸우" 소리를 냅니다.
* 2. 두번째 새는 "까악" 소리를 냅니다.
* 3. 마지막 새는 "짹짹" 소리를 냅니다.
* */


// 4번 제한 로직
//fun main() = runBlocking {
//
//    val firstBird = launch { birdSoundPrint(times = 4, timeMillis = 1000L, printSound = "꾸우") }
//
//    val secondBird = launch { birdSoundPrint(times = 4, timeMillis = 2000L, printSound = "까악") }
//
//
//    val thirdBird = launch { birdSoundPrint(times = 4, timeMillis = 3000L, printSound = "짹짹") }
//
//    joinAll(firstBird, secondBird, thirdBird)
//}

//suspend fun birdSoundPrint(times: Int, timeMillis: Long, printSound: String) {
//    repeat(times) {
//        delay(timeMillis)
//        println(printSound)
//    }
//}


// 계속 출력
suspend fun birdSoundPrint(timeMillis: Long, printSound: String) {
    while (currentCoroutineContext().isActive) {
        delay(timeMillis)
        println(printSound)
    }
}

fun main() = runBlocking {
    val topJob = SupervisorJob()        // 에러 발생시 부모로 에러 전파가 부모 코루틴까지 취소되어 나머지 자식은 실행 안딤

    // 부모 Job을 기준으로 Scope 생성
    val coroutineScope = CoroutineScope(Dispatchers.Default + topJob)

    coroutineScope.launch { birdSoundPrint(timeMillis = 1000L, printSound = "꾸우") }
    coroutineScope.launch { birdSoundPrint(timeMillis = 2000L, printSound = "까악") }
    coroutineScope.launch { birdSoundPrint(timeMillis = 3000L, printSound = "짹짹") }

    delay(10000L)

    coroutineScope.cancel()
}


