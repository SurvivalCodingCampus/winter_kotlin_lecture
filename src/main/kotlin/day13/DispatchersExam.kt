package day13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.io.File

suspend fun saveFile(content: String) {
    withContext(Dispatchers.IO) { // 디스패처를 전환해 주는 함수
        File("output.txt").writeText(content)  // 파일 저장 로직
        delay(3000)
        println("코루틴 1: ${Thread.currentThread().name}")  // 코루틴 1: DefaultDispatcher-worker-1
//        withContext(Dispatchers.Main) { // 안드로이드 환경에서 가능
//            println("코루틴 2: ${Thread.currentThread().name}")  // 디스패처를 전환하여 Worker 스레드와 Main스레드를 넘나들 수 있다.
//        }
    }
}

// 사용 예시
fun main() = runBlocking {
    val content = "Hello, World!"
    saveFile(content)  // IO 디스패처에서 비동기로 실행
    println("File saved!")
}