package day14.user

import io.kotest.common.runBlocking
import org.example.day14.user.UserHttpRepositoryImpl
import org.junit.Test

class UserHttpRepositoryImplTest {
    val userHttpRepositoryImpl = UserHttpRepositoryImpl()

    @Test
    fun getUsers() = runBlocking {
        val users = userHttpRepositoryImpl.getUsers()
        println(users[0])
    }

}