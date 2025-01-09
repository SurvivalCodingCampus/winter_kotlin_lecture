package day16

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.util.date.*
import java.io.File
import kotlin.time.measureTime

interface ImageDataSource {
    suspend fun fetchImage(url: String): ByteArray
    suspend fun saveImage(bytes: ByteArray, path: String)
}

interface ImageRepository {
    suspend fun saveImage(url: String, path: String): DownloadInfo
    suspend fun saveImages(urls: List<String>, directory: String): List<DownloadInfo>
    suspend fun saveImageIfNotExists(url: String, path: String): DownloadInfo?
}

class ImageDataSourceImpl: ImageDataSource {
    override suspend fun fetchImage(url: String): ByteArray {
        val client = HttpClient { HttpClient(CIO) }

        return client.get(url).bodyAsBytes()
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        val file = File(path)
        file.writeBytes(bytes)
        //file.delete()
    }
}

class ImageRepositoryImpl(private val dataSource: ImageDataSource): ImageRepository {
    override suspend fun saveImage(url: String, path: String): DownloadInfo {
        val startTime = getTimeMillis()
        println("다운로드 시작")
        val content: ByteArray
        val duration = measureTime {
            content = dataSource.fetchImage(url)
            dataSource.saveImage(content, path)
        }
        val endTime = getTimeMillis()
        println("다운로드 끝")
        println("=========")
        println("소요시간 : ${duration.inWholeMilliseconds}")

        return DownloadInfo(startTime.toString(), endTime.toString(), duration.inWholeMilliseconds.toString(), content.size.toString())
    }

    override suspend fun saveImages(urls: List<String>, directory: String): List<DownloadInfo> {
        val downloadInfo = mutableListOf<DownloadInfo>()

//        for(i in urls.indices) {
//            val startTime = getTimeMillis()
//            println("다운로드 시작")
//            val content: ByteArray
//            val duration = measureTime {
//                content = dataSource.fetchImage(urls[i])
//                dataSource.saveImage(content, directory)
//            }
//            dataSource.saveImage(dataSource.fetchImage(urls[i]), directory)
//        }
        for(i in urls.indices) {
            downloadInfo.add(saveImage(urls[i], directory))
            // client를 하나만 사용하면 성능이 안좋을 수 있다. 그럴 경우 client를 한 3개쯤 만들어 병렬로 처리해주는 것을 고려할 수 있다.
            // client는 내부에서 불러오므로 여기에서는 코루틴 병렬로 인덱스를 나눠서
            // 반복 돌리는 형태가 될 것이다.
        }
        return downloadInfo
    }

    override suspend fun saveImageIfNotExists(url: String, path: String): DownloadInfo? {
        if(File(path).isFile()) {
            println("파일이 이미 존재합니다.")
            return null
        }

        return saveImage(url, path)
    }
}