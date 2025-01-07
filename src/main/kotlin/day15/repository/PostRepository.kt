package day15.repository

import day15.model.Post
/*
과제 6. Repository 작성 연습 6
https://jsonplaceholder.typicode.com/posts
의 정보를 데이터소스로 하는 PostRepository 를 작성하시오.

작성할 메소드
suspend fun getPost(int id) : Post
suspend fun getPosts(page: Int = 1, limit: Int? = null) : List<Post>
한 페이지당 limit 갯수만큼 끊어서 보여줌
page 는 1부터 시작, 1보다 작은 값을 입력하면 1로 취급

구조
kotlin-study/
├── src/
│   └── main/
│       └── kotlin/
│           └── day15/
│               └── data_source/
│                   └── PostDataSource.kt
│                   └── MockPostDatasourceImpl.kt
│               └── model/
│                   └── Post
│               └── repository/
│                   └── PostRepository
│                   └── PostRepositoryImpl
*/
interface PostRepository {
    suspend fun getPost(id: Int) : Post
    suspend fun getPosts(page: Int = 1, limit: Int? = null) : List<Post>
}