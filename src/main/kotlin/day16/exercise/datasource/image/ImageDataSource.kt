package day16.exercise.datasource.image

import day15.common.ResponseResult
import day16.exercise.model.DownloadInfo

/*
* 사진 다운로드 기능
*
* 1. 네트워크 상의 파일을 다운로드 받는 기능을 작성. ByteArray는 byte[]다. 즉, 메모리에 쓸 수 있는 가장 원초적인 타입
* 2. 다음의 기능을 구현
* */
interface ImageDataSource {
    suspend fun fetchImage(url: String): ResponseResult<ByteArray>

    suspend fun saveImage(bytes: ByteArray, path: String)
}