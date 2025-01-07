package day15.repository

import day15.model.Photo

/*
과제 2. Repository 작성 연습 2
https://jsonplaceholder.typicode.com/photos
의 정보를 데이터소스로 하는 PhotoRepository 를 작성하시오.

작성할 메소드
suspend fun getPhotos(int albumId) : List<Photo>

구조
kotlin-study/
├── src/
│   └── main/
│       └── kotlin/
│           └── day15/
│               └── data_source/
│                   └── PhotoDataSource.kt
│                   └── MockPhotoDatasourceImpl.kt
│               └── model/
│                   └── Photo
│               └── repository/
│                   └── PhotoRepository
│                   └── PhotoRepositoryImpl
*/
interface PhotoRepository {
    suspend fun getPhotos(albumId: Int): List<Photo>
}