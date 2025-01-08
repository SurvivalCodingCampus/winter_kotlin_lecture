package day15.repository.user

import day15.model.User

interface UserRepository {
    // 전체 사용자 정보 조회
    suspend fun getUsers() : List<User>

    // username 기준 상위 10명
    suspend fun getUsersTop10ByUserName() : List<User>

}