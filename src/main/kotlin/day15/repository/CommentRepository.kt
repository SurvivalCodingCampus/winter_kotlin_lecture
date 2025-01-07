package day15.repository

import day15.model.Comment

/*
과제 1. Repository 작성 연습 1
https://jsonplaceholder.typicode.com/comments
의 정보를 데이터소스로 하는 CommentRepository 를 작성하시오.
MockCommentDatasourceImpl
CommentRepositoryImpl

작성할 메소드
suspend fun getComments(int postId): List<Comment>

구조
kotlin-study/
├── src/
│   └── main/
│       └── kotlin/
│           └── day15/
│               └── data_source/
│                   └── CommentDataSource.kt
│                   └── MockCommentDatasourceImpl.kt
│               └── model/
│                   └── Comment
│               └── repository/
│                   └── CommentRepository
│                   └── CommentRepositoryImpl
*/

interface CommentRepository {
    suspend fun getComments(postId: Int): List<Comment>
}
