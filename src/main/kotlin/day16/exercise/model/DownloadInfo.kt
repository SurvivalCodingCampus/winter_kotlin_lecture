package day16.exercise.model

/*
* 다운로드 시간 및 용량 표시를 위한 data class
*
*
* */
data class DownloadInfo(
    val startTime: String,
    val endTime: String,
    val elapsedTime: String,
    val fileSize: String,
) {
    fun printDownloadData() {
        val data = """
            다운로드 시작
            다운로드 끝
            =========
            소요시간: $elapsedTime
            용량: ${fileSize}bytes
        """.trimIndent()

        println(data)
    }
}


