package day12

// 1. 먼저 인터페이스 정의
interface OnCompleteCallback {
    fun onComplete()
}

// 2-1. 타이머 예제(값을 전달하지 않는 콜백 함수)
class Timer {
    // 타이머 끝나면 실행할 코드를 미리 등록
    //fun start(callback: OnCompleteCallback) {
    fun start(callback: () -> Unit) { // 콜백용 인터페이스 함수 1개라면 인터페이스 대신 함수로 대체 가능
        println("타이머 시작")
        Thread.sleep(1000) // 1초 대기
        //callback.onComplete() //등록해둔 코드 실행
        callback() // 전달받은 함수 실행
    }
}

// 2-2. 다운로더 예제(값을 전달하는 콜백 함수)
class Downloader {
    fun download(onProgress: (Int) -> Unit) {
        println("다운로드 시작")
        for (progress in 0..100 step 20) {
            Thread.sleep(500)  // 0.5초 대기
            onProgress(progress)  // 진행률 전달
        }
    }
}


// 사용 방법
// 1.콜백 인터페이스를 파라미터로 받고 특정 시점에 메서드를 호출
// 2.람다로 전달
// 3.함수 레퍼런스로 전달
fun main() {
    val timer = Timer()
    /*
    timer.start(object : OnCompleteCallback {
        override fun onComplete() {
            println("땡") // 1초 후 실행될 코드
        }
    })
    */
    timer.start { println("땡") } // 파라미터가 함수면 () 생략 가능

    // 함수 레퍼런스로 전달
    /*
    fun onComplete() {
        println("땡")
    }
    timer.start(::onComplete)
    */


    val downloader = Downloader()
    downloader.download { progress ->
        println("다운로드 진행률: $progress%")
    }

   /*
   활용 패턴
   1.비동기 작업의 결과 처리
   2.진행 상황 모니터링
   3.에러 처리
   */
}
