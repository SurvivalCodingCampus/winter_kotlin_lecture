package day16.exercise.repository.image

import day15.common.ResponseResult
import day16.exercise.datasource.image.ImageDataSource
import day16.exercise.datasource.image.ImageDataSourceImpl
import day16.util.Const
import day16.util.Const.DIRECTORY_NAME
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.io.File

class ImageRepositoryImpl(
    private val imageDataSource: ImageDataSource
) : ImageRepository {
    override suspend fun saveImage(url: String, path: String): Unit = withContext(Dispatchers.IO) {
        when (val downloadData = imageDataSource.fetchImage(url)) {
            is ResponseResult.Success -> {
                imageDataSource.saveImage(downloadData.data, path)
            }

            is ResponseResult.Failure -> {
                println("이미지 다운로드 실패 : ${downloadData.exception.message}")
            }
        }
    }

    override suspend fun saveImages(urls: List<String>, directory: String): Unit = withContext(Dispatchers.IO) {

        // 외부에서 디렉토리 명 입력 해서 해당 디렉토리에 쌓이게 하기
        val dir = File(directory)

        // 해당 디렉토리가 없을 경우 생성해줌
        if (!dir.exists()) {
            dir.mkdirs()
        }

        // url 리스트에서 하나씩 불러와서 정한 경로로 하나씩 저장
        urls.forEachIndexed { idx, url ->
            val filePath = File(dir, "meerkat${idx + 1}.txt")
            saveImage(url, filePath.absolutePath)
        }
    }

    // 이미지가 존재하지 않는 경우에만 URL에서 다운로드 저장
    override suspend fun saveImageIfNotExists(url: String, path: String): Boolean = withContext(Dispatchers.IO) {
        val dir = File(DIRECTORY_NAME)

        // 해당 디렉토리가 없을 경우 생성해줌
        if (!dir.exists()) {
            dir.mkdirs()
        }

        // 파일 체크를 위한 경로
        val filePath = File(dir, path)

        // 파일이 존재하는지 체크함
        if (filePath.exists()) {
            println("해당 파일이 이미 존재합니다.")
            false
        } else {
            saveImage(url, filePath.absolutePath)
            true
        }
    }
}

fun main() = runBlocking {
    val imageRepositoryImpl = ImageRepositoryImpl(ImageDataSourceImpl())
    val result = imageRepositoryImpl.saveImageIfNotExists(
        Const.testImageUrl4, "meerkat4.txt"
    )

    println(result)
}