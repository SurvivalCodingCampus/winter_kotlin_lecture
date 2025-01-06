package day14

import kotlinx.coroutines.test.runTest
import kotlin.test.*

class UserDataSourceImplTest {

    @Test
    fun `JSON List가 데이터클래스 리스트로 변환되는지 확인`() = runTest {
        val userData = UserDataSourceImpl()
        val userList = userData.getUsers()

        assertNotNull(userList)
        assertTrue(userList is List<User>)
        assertEquals(9, userList.lastIndex)
    }

}