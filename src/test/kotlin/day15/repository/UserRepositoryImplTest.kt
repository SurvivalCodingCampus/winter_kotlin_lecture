package day15.repository

import day15.data_source.MockUserDatasourceImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.*

class UserRepositoryImplTest {

    @Test
    fun `모든 User JSON 데이터를 가져오는지 확인`() = runTest {
        val repository = UserRepositoryImpl(MockUserDatasourceImpl())
        val users = repository.getUsers()

        assertEquals(10, users.size)
    }

    @Test
    fun `User JSON 데이터를 사용자명순으로 10개 가져오는지 확`() = runTest {
        val repository = UserRepositoryImpl(MockUserDatasourceImpl())
        val topUsers = repository.getUsersTop10ByUserName()

        assertEquals("Antonette", topUsers[0].username)
        assertEquals("Samantha", topUsers[9].username)
        assertEquals(10, topUsers.size)
    }
}