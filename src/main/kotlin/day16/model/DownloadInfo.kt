package day16.model

data class DownloadInfo(
    val startTime: String,
    val endTime: String,
    val elapsedTime: String,
    val fileSize: String
) {
    // 출력 포맷에 맞게 반환하는 메소드
    fun printDownloadInfo() {
        println("다운로드 시작")
        println("다운로드 끝")
        println("==========")
        println("소요시간: $elapsedTime")
        println("용량: $fileSize Bytes")
    }
}
