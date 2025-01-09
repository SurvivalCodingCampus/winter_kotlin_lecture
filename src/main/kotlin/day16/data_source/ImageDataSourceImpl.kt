package day16.data_source

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.io.IOException
import java.io.File

class ImageDataSourceImpl(private val client: HttpClient = HttpClient(CIO)) : ImageDataSource {
    override suspend fun fetchImage(url: String): ByteArray {
        return try {
            client.get(url).bodyAsBytes()
        } catch (e: Exception) {
            ByteArray(0)
        }
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        return try {
            if (bytes.isNotEmpty()) {
                File(path).writeBytes(bytes)
            } else {
                throw IOException("빈 바이트 배열을 파일에 저장할 수 없습니다.")
            }
        } catch (e: IOException) {
            println("파일 저장 중 오류 발생: ${e.message}")
            throw e
        } catch (e: Exception) {
            println("예상치 못한 오류 발생: ${e.message}")
            throw e
        }
    }

}