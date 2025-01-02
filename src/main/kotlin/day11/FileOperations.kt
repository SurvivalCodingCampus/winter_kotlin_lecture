package day11

interface FileOperations {
    /**
     * 지정된 경로의 파일을 다른 경로로 복사
     *
     * @param sourcePath 복사할 원본 파일의 경로
     * @param targetPath 파일이 복사될 대상 경로
     */
    fun copy(sourcePath: String, targetPath: String)

}