package org.example.day12

class Downloader {
    fun download(onProgress: (Int) -> Unit) {
        println("다룬로드 시작")
        for (progress in 0..100 step 20) {
            Thread.sleep(500)
            onProgress(progress)
        }
    }
}

fun main() {
    val downloader = Downloader()
    downloader.download {
        println("진행률: $it")
    }
}