package day12
// 값을 전달하는 콜백 함수

class Downloader {
    fun download(onProgress: (Int) -> Unit) {
        println("다운로드 시작")
        for (progress in 0..100 step 20) {
            Thread.sleep(1000)
            onProgress(progress)
        }
    }
}

fun main() {
    val downloader = Downloader()
    downloader.download {
        progress -> println("다운로드 진행률 : $progress%")
    }
}