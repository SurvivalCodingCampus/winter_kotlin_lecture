package day16.repository

import day16.model.DownloadInfo

/*
연습문제 2. 사진 다운로드 기능
네트워크 상의 사진 파일을 다운로드 받는 기능을 작성한다.

연습문제 3.  다운로드 시간, 용량 표시
연습문제 2를 수정하여 다음과 같은 결과를 표시하는 프로그램에 활용 가능하도록 수정하시오.
다운로드 시작
다운로드 끝
==========
소요시간 : 0:00:00.184481
용량 : 1150bytes

구조
kotlin-study/
├── src/
│   └── main/
│       └── kotlin/
│           └── day16/
│               └── data_source/
│                   └── ImageDataSource
│                   └── MockImageDatasource
│                   └── ImageDatasourceImpl
│               └── repository/
│                   └── ImageRepository
│                   └── ImageRepositoryImpl
*/

interface ImageRepository {
    // URL에서 이미지를 다운로드하여 지정된 경로에 저장
    suspend fun saveImage(url: String, path: String): DownloadInfo

    // 여러 URL의 이미지들을 지정된 디렉토리에 저장
    suspend fun saveImages(urls: List<String>, directory: String): List<DownloadInfo>

    // 이미지가 존재하지 않는 경우에만 URL에서 다운로드하여 저장
    suspend fun saveImageIfNotExists(url: String, path: String): DownloadInfo?
}