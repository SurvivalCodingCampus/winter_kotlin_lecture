package day14

import kotlinx.coroutines.runBlocking
import org.example.day14.UserDataSourceImpl
import org.junit.Assert.assertEquals
import org.junit.Test

class UserDataSourceImplTest {
    private val userDataSource = UserDataSourceImpl()

    @Test
    fun `getTodos 데이터가 일치하는지 테스트 `() = runBlocking {
        val users = userDataSource.getUsers()

        val firstUser = users[0]
        assertEquals("Leanne Graham", firstUser.name)
        assertEquals("Bret", firstUser.username)
        assertEquals("Sincere@april.biz", firstUser.email)
        assertEquals("Kulas Light", firstUser.address.street)
    }
}