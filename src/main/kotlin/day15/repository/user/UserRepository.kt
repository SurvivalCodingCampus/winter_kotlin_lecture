package day15.repository.user

import day15.model.User

interface UserRepository {
    // 전체 User 정보 받아오기
    suspend fun getUsers() : List<User>

    // 이름 기준 상위 10명
    suspend fun getUsersTop10ByUserName() : List<User>

}