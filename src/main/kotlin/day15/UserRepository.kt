package day15

import day14.User

interface UserRepository {
    suspend fun getAll(): List<User>
    suspend fun first10SortedByUserName(): List<User>
}