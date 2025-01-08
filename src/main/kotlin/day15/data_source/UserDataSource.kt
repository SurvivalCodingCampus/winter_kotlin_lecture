package day15.data_source

import day15.model.User

interface UserDataSource {
    suspend fun userData(): List<User>
}