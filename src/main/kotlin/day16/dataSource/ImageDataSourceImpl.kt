package day16.dataSource

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import java.io.File
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImageDataSourceImpl(private val client: HttpClient) : ImageDataSource {

    override suspend fun fetchImage(url: String): ByteArray {
        return try {
            val response: HttpResponse = client.get(url)   // 이미지 다운로드
            response.bodyAsBytes()  // 이미지를 ByteArray로 반환
        } catch (e: Exception) {
            println(e.message)
            throw e
        }
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        try {
            withContext(Dispatchers.IO) {
                val file = File(path)
                file.writeBytes(bytes)  // ByteArray를 지정된 경로에 파일로 저장
            }
        } catch (e: Exception) {
            println(e.message)
            throw e
        }
    }
}
