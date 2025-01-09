package day16.data

interface ImageRepository {
    suspend fun saveImage(url: String, path: String): DownloadInfo
    suspend fun saveImage(urls: List<String>, directory: String): List<DownloadInfo>
    suspend fun saveImageIfNotExists(url: String, path: String): DownloadInfo?
}