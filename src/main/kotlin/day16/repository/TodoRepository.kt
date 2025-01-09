package day16.repository

import day16.model.Todo
/*
연습문제 4 - HttpClient Mocking

HttpClient 를 Mocking 하여 테스트하는 테스트코드를 작성하시오.
https://ktor.io/docs/client-testing.html#test-client
TodoDataSource 인터페이스 추출하고 Mock 객체 작성
TodoRepository 를 작성한 Mock 객체로 테스트

구조
kotlin-study/
├── src/
│   └── main/
│       └── kotlin/
│           └── day16/
│               └── data_source/
│                   └── TodoDataSource
│                   └── MockTodoDatasource
│                   └── TodoDatasourceImpl
│               └── model/
│                   └── Todo
│               └── repository/
│                   └── TodoRepository
│                   └── TodoRepositoryImpl
*/

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun getTodo(id: Int): Todo
}