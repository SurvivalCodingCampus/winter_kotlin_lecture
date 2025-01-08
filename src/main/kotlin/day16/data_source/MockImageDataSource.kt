package day16.data_source

class MockImageDataSource : ImageDataSource {
    private val savedFiles = mutableSetOf<String>() // 파일 시스템 없이 이미 저장된 파일을 추적하기 위함

    override suspend fun fetchImage(url: String): ByteArray {
        return byteArrayOf(1, 2, 3) // 이미지 데이터 반환
    }

    override suspend fun saveImage(bytes: ByteArray, path: String) {
        if (savedFiles.contains(path)) {
            println("이미 이미지가 존재합니다: $path")
        } else {
            savedFiles.add(path) // 이미 저장된 파일을 추적
            println("$path 이미지가 저장되었습니다")
        }
    }

    // 테스트에서 파일이 저장되었는지 확인하는 메서드
    fun isFileSaved(path: String): Boolean {
        return savedFiles.contains(path)
    }

    // 파일 저장을 초기화하는 메서드
    fun clearSavedFiles() {
        savedFiles.clear()
    }

}
