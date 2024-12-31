package org.example.day11

/**
 * 기본적인 파일 작업을 정의하는 인터페이스
 *
 * 이 인터페이스는 파일 시스템에서 수행되는 기본적인 작업을 정의합니다.
 * 현재는 파일 복사 기능만 포함하고 있으며, 버퍼링이나 에러 처리는 구현하지 않습니다.
 */
interface FileOperations {
    /**
     * 지정된 경로의 파일을 다른 경로로 복사합니다.
     *
     * @param sourcePath 복사할 원본 파일의 경로
     * @param targetPath 파일이 복사될 대상 경로
     *
     *
     */
    fun copy(sourcePath: String, targetPath: String)
}