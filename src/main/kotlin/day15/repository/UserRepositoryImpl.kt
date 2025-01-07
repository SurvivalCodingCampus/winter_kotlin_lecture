package day15.repository

import day15.data_source.UserDataSource
import day15.model.User

class UserRepositoryImpl(private val dataSource: UserDataSource):UserRepository {
    override suspend fun getUsers(): List<User> {
        return dataSource.getUsers()
    }

    override suspend fun getUsersTop10ByUserName(): List<User> {
        return dataSource.getUsersTop10ByUserName()
    }
}
