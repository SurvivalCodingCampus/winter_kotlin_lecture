package day15.repository

import day15.dataSource.UserDataSource
import day15.model.User

class UserRepositoryImpl(private val dataSource: UserDataSource): UserRepository {

    override suspend fun getUsers(): List<User> {
        return dataSource.userData()
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        val jsonList = getUsers()
        return jsonList.sortedBy { it.name }.take(10)
    }
}