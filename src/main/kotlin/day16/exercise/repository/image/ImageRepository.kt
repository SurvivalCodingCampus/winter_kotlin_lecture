package day16.exercise.repository.image

import day16.exercise.model.DownloadInfo

interface ImageRepository {

    // URL에서 이미지를 다운로드하여 지정된 경로에 저장
    suspend fun saveImage(url: String, path: String): DownloadInfo?

    // 여러 URL의 이미지들을 지정된 디렉토리에 저장
    suspend fun saveImages(urls: List<String>, directory: String): List<DownloadInfo>

    // 이미지가 존재하지 않는 경우에만 URL에서 다운로드하여 저장
    suspend fun saveImageIfNotExists(url: String, path: String): DownloadInfo?
}