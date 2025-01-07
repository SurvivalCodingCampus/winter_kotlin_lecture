package day15.data_source

import day15.model.User

interface UserDataSource {
    fun getUsers() : List<User>
    fun getUsersTop10ByUserName() : List<User>
}