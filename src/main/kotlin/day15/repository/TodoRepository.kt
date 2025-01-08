package day15.repository

import day15.model.Todo

/*
과제 3. Repository 작성 연습 3
https://jsonplaceholder.typicode.com/todos
의 정보를 데이터소스로 하는 TodoRepository 를 작성하시오.

작성할 메소드
suspend fun getTodos(): List<Todo>
suspend fun getCompletedTodos() : List<Todo>

구조
kotlin-study/
├── src/
│   └── main/
│       └── kotlin/
│           └── day15/
│               └── data_source/
│                   └── TodoDataSource.kt
│                   └── MockTodoDatasourceImpl.kt
│               └── model/
│                   └── Todo
│               └── repository/
│                   └── TodoRepository
│                   └── TodoRepositoryImpl
*/
interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun getCompletedTodos() : List<Todo>
}