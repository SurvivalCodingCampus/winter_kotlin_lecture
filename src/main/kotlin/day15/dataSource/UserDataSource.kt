package day15.dataSource

import day15.model.User

interface UserDataSource {
    suspend fun userData(): List<User>
}