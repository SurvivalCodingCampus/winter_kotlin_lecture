package day16.data

import io.ktor.http.*
import kotlinx.datetime.Clock
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString
import kotlin.io.path.exists
import kotlin.io.path.isDirectory
import kotlin.time.measureTimedValue
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

class ImageRepositoryImpl(private val source: ImageDataSource) : ImageRepository {
    override suspend fun saveImage(url: String, path: String): DownloadInfo {
        println("다운로드 시작")
        val now = Clock.System.now()
        val image = measureTimedValue {
            source.fetchImage(url)
        }
        val finished = Clock.System.now()
        println("다운로드 끝")
        println("===========")
        println("소요시간 : ${image.duration}")
        println("용량 : ${image.value.size}bytes")
        source.saveImage(image.value, path)
        return DownloadInfo(now.toString(), finished.toString(), image.duration.toString(), image.value.size.toString())
    }

    @OptIn(ExperimentalUuidApi::class)
    override suspend fun saveImage(urls: List<String>, directory: String): List<DownloadInfo> {
        val destination = Path(directory)
        require(destination.isDirectory())

        return urls.map {
            val ext = Url(it).encodedPath.split('.').last()
            val fileName = "${Uuid.random()}.${ext}"
            saveImage(it, destination.resolve(fileName).absolutePathString())
        }
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): DownloadInfo? {
        if (Path(path).exists()) return null
        return saveImage(url, path)
    }

}