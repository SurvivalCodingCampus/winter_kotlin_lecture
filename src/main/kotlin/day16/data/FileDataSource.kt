package day16.data

interface FileDataSource {
    suspend fun saveImage(bytes: ByteArray, path: String)
}