package day13

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

suspend fun function1(): Int {
    delay(1000L)
    return 10
}

suspend fun function2(): Int {
    delay(2000L)
    return 20
}

fun main() = runBlocking {
    val time = measureTimeMillis {
        /*
        // suspend 함수 2개를 실행하면 순차적으로 실행 됨 30 ms
        val one = function1()
        val two = function2()
        println("The answer is ${one + two}") */

        /*
        // async코루틴빌더와 await함수로 병렬 실행 30ms. Deferred는 await()통해 미래의 값을 얻는다.
        val one: Deferred<Int> = async { function1() }
        val two: Deferred<Int> = async { function2() }
        println("The answer is ${one.await() + two.await()}") */

       /* launch는 Job을 리턴한다. Job을 통해 실행중인 코루틴을 제어할 수 있다. 1,2,3 출력
        join()은 해당 코루틴 내의 처리가 끝나는 것을 기다린다.
        Job을 통해 코루틴 취소 가능 1, 3, 14ms, 0,1 is running, 코루틴 취소!!!
        */
        println(1)
        val job: Job = launch {
            repeat(5) {
                println("Coroutine $it is running")
                delay(1000L)
            }
            println(2)
        }

        launch {
            delay(2000L)
            job.cancel()
            println("코루틴 취소!!!")
        }
        // job.join()
        println(3)
    }
    println("Completed in $time ms")
}