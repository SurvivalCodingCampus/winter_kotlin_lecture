package day15.repository

import day15.model.User
/*
과제 4. Repository 작성 연습 4
https://jsonplaceholder.typicode.com/users
의 정보를 데이터 소스로 하는 UserRepository 를 작성하시오.

작성할 메소드
suspend fun getUsers() : List<User>
suspend fun getUsersTop10ByUserName() : List<User>

구조
kotlin-study/
├── src/
│   └── main/
│       └── kotlin/
│           └── day15/
│               └── data_source/
│                   └── UserDataSource.kt
│                   └── MockUserDatasourceImpl.kt
│               └── model/
│                   └── User
│               └── repository/
│                   └── UserRepository
│                   └── UserRepositoryImpl
*/
interface UserRepository {
    suspend fun getUsers() : List<User>
    suspend fun getUsersTop10ByUserName() : List<User>
}