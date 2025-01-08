package day14

interface UserDataSource {
    suspend fun getUsers(): List<User>
}