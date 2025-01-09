import org.example.day16.repository.ImageRepository
import java.io.File
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class ImageRepositoryImpl(
    private val imageDataSource: ImageDataSource,
    private val basePath: String = "./src/main/kotlin/day16/downloads/"
) : ImageRepository {
    override suspend fun saveImage(url: String, path: String): Double {
        val bytes = imageDataSource.fetchImage(url)
        val sizeInKB = bytes.size / 1024.0
        val fullPath = "$basePath$path"

        imageDataSource.saveImage(bytes, fullPath)

        return sizeInKB
    }

    override suspend fun saveImages(urls: List<String>, directory: String) {
        urls.forEachIndexed { index, url ->
            val path = "$directory/image_$index.jpg"
            saveImage(url, path)
        }
    }

    override suspend fun saveImageIfNotExists(urls: String, path: String): DownloadInfo? {
        val fullPath = "$basePath$path"
        return if (!File(fullPath).exists()) {
            val startTime = LocalDateTime.now()
            println("다운로드 시작")
            val sizeInKb = saveImage(url, path)
            println("다운로드 끝")
            println("===============")
            val endTime = LocalDateTime.now()


            val elapsedTime = endTime.nano - startTime.nano
            val duration = Duration.between(startTime, endTime)

            val durationTIme = LocalTime.ofNanoOfDay(duration.toNanos())
            val foramttedDuration = durationTIme.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSSSSSS"))



            println("소요시간 : $foramttedDuration")
            println("용량 : ${String.format("%.2f", sizeInKb)} KB")

            DownloadInfo(startTime.toString(), endTime.toString(), elapsedTime.toString(), "5")

        } else {
            return null
        }
    }

}
