package day15

import day14.User
import day14.UserDataSource

class UserRepositoryImpl(private val source: UserDataSource) : UserRepository {
    override suspend fun getAll(): List<User> = source.getUsers()

    override suspend fun first10SortedByUserName(): List<User> =
        source.getUsers().sortedWith { a, b -> a.username.compareTo(b.username) }.take(10)
}