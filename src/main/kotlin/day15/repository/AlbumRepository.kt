package day15.repository

import day15.model.Album
/*
과제 5. Repository 작성 연습 5
https://jsonplaceholder.typicode.com/albums
의 정보를 데이터소스로 하는 AlbumRepository 를 작성하시오.

작성할 메소드
suspend fun getAlbums(limit: Int? = null): List<Album>
limit 을 지정하지 않으면 모든 데이터를
limit 을 지정하면 limit 갯수만큼

구조
kotlin-study/
├── src/
│   └── main/
│       └── kotlin/
│           └── day15/
│               └── data_source/
│                   └── AlbumDataSource.kt
│                   └── MockAlbumDatasourceImpl.kt
│               └── model/
│                   └── Album
│               └── repository/
│                   └── AlbumRepository
│                   └── AlbumRepositoryImpl
*/
interface AlbumRepository {
    suspend fun getAlbums(limit: Int? = null): List<Album>
}