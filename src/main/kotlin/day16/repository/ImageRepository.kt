package day16.repository

interface ImageRepository {
    suspend fun saveImage(url: String, path: String)                        // url에서 이미지를 다운로드하여 저장된 경로에 저장
    suspend fun saveImages(urls: List<String>, directory: String)           // 여러 url의 이미지들을 저장된 디렉토리에 저장
    suspend fun saveImageIfNotExists(url: String, path: String): Boolean    // 이미지가 존재하지 않는 경우에만 url에서 다운로드하여 저장
}