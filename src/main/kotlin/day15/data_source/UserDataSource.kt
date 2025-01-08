package day15.data_source

import day15.model.User

interface UserDataSource {
    suspend fun getUsers() : List<User>
    suspend fun getUsersTop10ByUserName() : List<User>
}