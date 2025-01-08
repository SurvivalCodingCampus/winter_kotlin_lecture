package day16.exercise.repository.image

import day15.common.ResponseResult
import day16.exercise.datasource.image.ImageDataSource
import day16.exercise.datasource.image.ImageDataSourceImpl
import day16.exercise.model.DownloadInfo
import day16.util.CommonUtils.formattedTime
import day16.util.Const
import day16.util.Const.DIRECTORY_NAME
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.io.File

class ImageRepositoryImpl(
    private val imageDataSource: ImageDataSource
) : ImageRepository {
    override suspend fun saveImage(url: String, path: String): DownloadInfo? = withContext(Dispatchers.IO) {
        // 다운로드 시간 측정
        val startTime = System.currentTimeMillis()
        when (val downloadData = imageDataSource.fetchImage(url)) {
            is ResponseResult.Success -> {
                val result = imageDataSource.saveImage(downloadData.data, path)

                // 다운로드 종료 시간 측정
                val endTime = System.currentTimeMillis()

                // 파일 크기 측정
                val fileSize = result.let { File(path).length() }

                // 경과 시간 계산
                val elapsedTime = endTime - startTime

                val formattedElapsedTime = formattedTime(elapsedTime)

                val downloadInfo = DownloadInfo(
                    startTime = startTime.toString(),
                    endTime = endTime.toString(),
                    elapsedTime = formattedElapsedTime,
                    fileSize = fileSize.toString(),
                )

                downloadInfo.printDownloadData()

                return@withContext downloadInfo

            }

            is ResponseResult.Failure -> {
                println("이미지 다운로드 실패 : ${downloadData.exception.message}")
                null
            }
        }
    }

    override suspend fun saveImages(urls: List<String>, directory: String): List<DownloadInfo> =
        withContext(Dispatchers.IO) {

            val downloadInfoList = mutableListOf<DownloadInfo>()


            // 시작 시간
            val startTime = System.currentTimeMillis()


            // 외부에서 디렉토리 명 입력 해서 해당 디렉토리에 쌓이게 하기
            val dir = File(directory)

            // 해당 디렉토리가 없을 경우 생성해줌
            if (!dir.exists()) {
                dir.mkdirs()
            }

            // url 리스트에서 하나씩 불러와서 정한 경로로 하나씩 저장
            urls.forEachIndexed { idx, url ->
                val filePath = File(dir, "meerkat${idx + 1}.txt")

                // 개별 다운로드 시간 측정
                val downloadInfo = saveImage(url, filePath.absolutePath)
                downloadInfo?.let { info ->
                    downloadInfoList.add(info)
                }
            }

            // 끝나는 시간 기록
            val endTime = System.currentTimeMillis()

            // 전체 경과 시간
            val elapsedTime = endTime - startTime
            val formattedElapsedTime = formattedTime(elapsedTime)

            println("전체 다운로드 완료 후 걸린 시간: $formattedElapsedTime")

            // 다운이 끝난 정보 리스트 반환
            return@withContext downloadInfoList
        }

    // 이미지가 존재하지 않는 경우에만 URL에서 다운로드 저장
    override suspend fun saveImageIfNotExists(url: String, path: String): DownloadInfo? = withContext(Dispatchers.IO) {
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
            null
        } else {
            saveImage(url, filePath.absolutePath)
        }
    }
}

fun main() = runBlocking {
    val imageRepositoryImpl = ImageRepositoryImpl(ImageDataSourceImpl())
    val result = imageRepositoryImpl.saveImageIfNotExists(
        Const.testImageUrl1,
        "meerkat4.txt"
    )
    println(result)
}