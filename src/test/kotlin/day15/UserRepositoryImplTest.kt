package day15

import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class UserRepositoryImplTest {

    @Test
    fun getUsers() = runBlocking {
        val data = UserRepositoryImpl(MockUserDataSourceImpl()).getUsers()

        assertEquals(10, data.size)
    }

    @Test
    fun getUsersTop10ByUserName() = runBlocking {
        val data = UserRepositoryImpl(MockUserDataSourceImpl()).getUsersTop10ByUserName()

        assertEquals(10, data.size)

        // 데이터 내용 검증
        data.forEachIndexed { index, user ->
            assertNotNull(user.id)
            assertNotNull(user.name)
            assertNotNull(user.email)
        }

        // 정렬 검증
        val sortedData = data.sortedBy { it.username }
        assertEquals(sortedData, data)
    }
}