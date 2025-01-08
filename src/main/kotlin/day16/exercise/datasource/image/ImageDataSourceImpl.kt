package day16.exercise.datasource.image

import day15.common.ResponseResult
import day15.common.safeCall
import day16.util.HttpClientFactory
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.io.IOException
import java.io.File
import java.io.FileOutputStream

class ImageDataSourceImpl : ImageDataSource {
    override suspend fun fetchImage(url: String): ResponseResult<ByteArray> = withContext(Dispatchers.IO) {
        safeCall {
            HttpClientFactory.client.get(url).bodyAsBytes()
        }
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) = withContext(Dispatchers.IO) {
        try {
            val file = File(path)

            // 파일이 이미 존재하면 덮어쓰기
            FileOutputStream(file).use { outputStream ->
                outputStream.write(bytes)
            }

        } catch (e: IOException) {
            println("파일 저장 오류")
        }
    }
}